package com.nt.framework.service;

/**
 * 
 * @ClassName: CacheService
 * @Description: 缓存
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月11日 下午4:52:03
 */
public interface CacheService {
	/**
	 * 
	 * @Title: getDiskStorePath
	 * @Description: 获取缓存存储路径
	 * @return
	 * @return: String
	 */
	String getDiskStorePath();
	/**
	 * 
	 * @Title: getCacheSize
	 * @Description: 获取缓存数
	 * @return
	 * @return: int
	 */
	int getCacheSize();
}
