package com.nt.framework.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nt.framework.FileInfo;
import com.nt.framework.FileInfo.FileType;
import com.nt.framework.FileInfo.OrderType;

/**
 * 
 * @ClassName: FileService
 * @Description: Service - 文件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月26日 下午3:38:37
 */
public interface FileService {

	/**
	 * 
	 * @Title: isValid
	 * @Description: TODO
	 * @param fileType
	 * @param multipartFile
	 * @return
	 * @return: boolean
	 */
	boolean isValid(FileType fileType, MultipartFile multipartFile);

	/**
	 * 
	 * @Title: upload
	 * @Description: 文件上传
	 * @param fileType
	 * @param multipartFile
	 * @param async
	 * @return
	 * @return: String
	 */
	String upload(FileType fileType, MultipartFile multipartFile, boolean async);

	/**
	 * 文件上传(异步)
	 * 
	 * @param fileType
	 *            文件类型
	 * @param multipartFile
	 *            上传文件
	 * @return 访问URL
	 */
	String upload(FileType fileType, MultipartFile multipartFile);

	/**
	 * 文件上传至本地
	 * 
	 * @param fileType
	 *            文件类型
	 * @param multipartFile
	 *            上传文件
	 * @return 路径
	 */
	String uploadLocal(FileType fileType, MultipartFile multipartFile);

	/**
	 * 文件浏览
	 * 
	 * @param path
	 *            浏览路径
	 * @param fileType
	 *            文件类型
	 * @param orderType
	 *            排序类型
	 * @return 文件信息
	 */
	List<FileInfo> browser(String path, FileType fileType, OrderType orderType);
}
