package com.nt.framework.util;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 
 * @ClassName: CacheUtils
 * @Description: 缓存配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月9日 下午5:56:58
 */
public class CacheUtils {

	private static final CacheManager cacheManager = CacheManager.getInstance();

	/**
	 * 
	 * @Title: getEhcache
	 * @Description: 获取缓存对象
	 * @param cacheName
	 * @return
	 * @return: Ehcache
	 */
	public static Ehcache getEhcache(String cacheName) {
		return cacheManager.getEhcache(cacheName);
	}

	/**
	 * 
	 * @Title: getValue
	 * @Description: 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 * @return: Object
	 */
	public static Object getValue(String cacheName, Object key) {
		Ehcache ehcache = getEhcache(cacheName);
		Element ele = ehcache.get(key);
		if (ele != null) {
			return ele.getObjectValue();
		}
		return null;
	}

	/**
	 * 
	 * @Title: setElement
	 * @Description: 设置缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 * @return: void
	 */
	public static void setElement(String cacheName, Object key, Object value) {
		Ehcache ehcache = getEhcache(cacheName);
		ehcache.put(new Element(key, value));
	}

	/**
	 * 
	 * @Title: cleanEhCache
	 * @Description: 清除缓存
	 * @param cacheName
	 * @param key
	 * @return: void
	 */
	public static void cleanEhCache(String cacheName, Object key) {
		Ehcache ehcache = getEhcache(cacheName);
		if (key == null) {
			ehcache.removeAll();
		} else {
			ehcache.remove(key);
		}
	}
}
