package com.nt.framework.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.framework.FileInfo;
import com.nt.framework.FileInfo.FileType;
import com.nt.framework.FileInfo.OrderType;
import com.nt.framework.Setting;
import com.nt.framework.plugin.StoragePlugin;
import com.nt.framework.service.FileService;
import com.nt.framework.service.PluginService;
import com.nt.framework.util.ApplicationContextHelpers;
import com.nt.framework.util.FreemarkerUtils;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: FileServiceImpl
 * @Description: Service -- 文件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月26日 下午4:14:38
 */
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private TaskExecutor taskExecutor;

	@Autowired
	private PluginService pluginService;

	/**
	 * 
	 * @Title: isValid
	 * @Description: 文件验证
	 * @param fileType
	 * @param multipartFile
	 * @return
	 * @see com.nt.framework.service.FileService#isValid(com.nt.framework.FileInfo.FileType,
	 *      org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public boolean isValid(FileType fileType, MultipartFile multipartFile) {
		Setting setting = SettingUtils.getSetting();
		if (multipartFile == null) {
			return false;
		}
		if (setting.getUploadMaxSize() != null && setting.getUploadMaxSize() != 0 && multipartFile.getSize() > setting.getUploadMaxSize() * 1024L * 1024L) {
			return false;
		}
		String[] uploadExtensions;
		if (fileType == FileType.flash) {
			uploadExtensions = setting.getUploadFlashExtensions();
		} else if (fileType == FileType.media) {
			uploadExtensions = setting.getUploadMediaExtensions();
		} else if (fileType == FileType.file) {
			uploadExtensions = setting.getUploadFileExtensions();
		} else {
			uploadExtensions = setting.getUploadImageExtensions();
		}
		if (ArrayUtils.isNotEmpty(uploadExtensions)) {
			return FilenameUtils.isExtension(multipartFile.getOriginalFilename(), uploadExtensions);
		}
		return false;
	}

	@Override
	public String upload(FileType fileType, MultipartFile multipartFile, boolean async) {
		if (multipartFile == null) {
			return null;
		}
		Setting setting = SettingUtils.getSetting();
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = setting.getFlashUploadPath();
		} else if (fileType == FileType.media) {
			uploadPath = setting.getMediaUploadPath();
		} else if (fileType == FileType.file) {
			uploadPath = setting.getFileUploadPath();
		} else {
			uploadPath = setting.getImageUploadPath();
		}
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String path = FreemarkerUtils.process(uploadPath, model);
			String destPath = path + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());

			for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {
				File tempFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");
				if (!tempFile.getParentFile().exists()) {
					tempFile.getParentFile().mkdirs();
				}
				multipartFile.transferTo(tempFile);
				if (async) {
					addTask(storagePlugin, destPath, tempFile, multipartFile.getContentType());
				} else {
					try {
						storagePlugin.upload(destPath, tempFile, multipartFile.getContentType());
					} finally {
						FileUtils.deleteDirectory(tempFile);
					}
				}
				return storagePlugin.getUrl(destPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: upload
	 * @Description: 文件上传
	 * @param fileType
	 * @param multipartFile
	 * @return
	 * @see com.nt.framework.service.FileService#upload(com.nt.framework.FileInfo.FileType,
	 *      org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String upload(FileType fileType, MultipartFile multipartFile) {
		return upload(fileType, multipartFile, false);
	}

	/**
	 * 
	 * @Title: uploadLocal
	 * @Description: 文件上传到本地
	 * @param fileType
	 * @param multipartFile
	 * @return
	 * @see com.nt.framework.service.FileService#uploadLocal(com.nt.framework.FileInfo.FileType,
	 *      org.springframework.web.multipart.MultipartFile)
	 */
	@Override
	public String uploadLocal(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return null;
		}
		Setting setting = SettingUtils.getSetting();
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = setting.getFlashUploadPath();
		} else if (fileType == FileType.media) {
			uploadPath = setting.getMediaUploadPath();
		} else if (fileType == FileType.file) {
			uploadPath = setting.getFileUploadPath();
		} else {
			uploadPath = setting.getImageUploadPath();
		}
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String path = FreemarkerUtils.process(uploadPath, model);
			String destPath = path + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			File destFile = new File(ApplicationContextHelpers.getAppRealPath(destPath));
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(destFile);
			return destPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @Title: browser
	 * @Description: 文件浏览
	 * @param path
	 * @param fileType
	 * @param orderType
	 * @return
	 * @see com.nt.framework.service.FileService#browser(java.lang.String,
	 *      com.nt.framework.FileInfo.FileType,
	 *      com.nt.framework.FileInfo.OrderType)
	 */
	@Override
	public List<FileInfo> browser(String path, FileType fileType, OrderType orderType) {
		if (path != null) {
			if (!path.startsWith("/")) {
				path = "/" + path;
			}
			if (!path.endsWith("/")) {
				path += "/";
			}
		} else {
			path = "/";
		}
		Setting setting = SettingUtils.getSetting();
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = setting.getFlashUploadPath();
		} else if (fileType == FileType.media) {
			uploadPath = setting.getMediaUploadPath();
		} else if (fileType == FileType.file) {
			uploadPath = setting.getFileUploadPath();
		} else {
			uploadPath = setting.getImageUploadPath();
		}
		String browsePath = StringUtils.substringBefore(uploadPath, "${");
		browsePath = StringUtils.substringBeforeLast(browsePath, "/") + path;

		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		if (browsePath.indexOf("..") >= 0) {
			return fileInfos;
		}
		for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {
			fileInfos = storagePlugin.browser(browsePath);
			break;
		}
		if (orderType == OrderType.size) {
			Collections.sort(fileInfos, new SizeComparator());
		} else if (orderType == OrderType.type) {
			Collections.sort(fileInfos, new TypeComparator());
		} else {
			Collections.sort(fileInfos, new NameComparator());
		}
		return fileInfos;
	}

	/**
	 * 添加上传任务
	 * 
	 * @param storagePlugin
	 *            存储插件
	 * @param path
	 *            上传路径
	 * @param tempFile
	 *            临时文件
	 * @param contentType
	 *            文件类型
	 */
	private void addTask(final StoragePlugin storagePlugin, final String path, final File tempFile, final String contentType) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					storagePlugin.upload(path, tempFile, contentType);
				} finally {
					try {
						FileUtils.deleteDirectory(tempFile);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	private class NameComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory()).append(fileInfos1.getName(), fileInfos2.getName()).toComparison();
		}
	}

	private class SizeComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory()).append(fileInfos1.getSize(), fileInfos2.getSize()).toComparison();
		}
	}

	private class TypeComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory()).append(FilenameUtils.getExtension(fileInfos1.getName()), FilenameUtils.getExtension(fileInfos2.getName())).toComparison();
		}
	}

}
