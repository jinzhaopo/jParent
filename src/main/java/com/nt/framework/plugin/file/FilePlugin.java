package com.nt.framework.plugin.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import com.nt.framework.FileInfo;
import com.nt.framework.Setting;
import com.nt.framework.plugin.StoragePlugin;
import com.nt.framework.util.ApplicationContextHelpers;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: FilePlugin
 * @Description: 存储插件---plugin
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 下午3:57:23
 */
@Component("filePlugin")
public class FilePlugin extends StoragePlugin {

	@Override
	public String getName() {
		return "本地文件存储";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getAuthor() {
		return "jinzhaopo";
	}

	@Override
	public String getSiteUrl() {
		return SettingUtils.getSetting().getSiteUrl();
	}

	@Override
	public String getInstallUrl() {
		return null;
	}

	@Override
	public String getUninstallUrl() {
		return null;
	}

	@Override
	public String getSettingUrl() {
		return "file/setting.jhtml";
	}

	@Override
	public void upload(String path, File file, String contentType) {
		File destFile = new File(ApplicationContextHelpers.getAppRealPath(path));
		try {
			FileUtils.copyFile(file, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getUrl(String path) {
		return SettingUtils.getSetting().getSiteUrl() + path;
	}

	@Override
	public List<FileInfo> browser(String path) {
		Setting setting = SettingUtils.getSetting();
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		File directory = new File(ApplicationContextHelpers.getAppRealPath(path));
		if (directory.exists() && directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setName(file.getName());
				fileInfo.setUrl(setting.getSiteUrl() + path + file.getName());
				fileInfo.setIsDirectory(file.isDirectory());
				fileInfo.setSize(file.length());
				fileInfo.setLastModified(new Date(file.lastModified()));
				fileInfos.add(fileInfo);
			}
		}
		return fileInfos;
	}

}