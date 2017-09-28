package com.nt.framework.service;

import java.util.List;

import com.nt.framework.model.PluginConfig;
import com.nt.framework.plugin.StoragePlugin;

/**
 * 
 * @ClassName: PluginService
 * @Description: Service - 插件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 下午4:16:47
 */
public interface PluginService {
	/**
	 * 
	 * @Title: getStoragePluginsByPluginConfigs
	 * @Description: 将插件的配置转换成存储插件
	 * @param pluginConfigs
	 * @return
	 * @return: List<StoragePlugin>
	 */
	List<StoragePlugin> getStoragePluginsByPluginConfigs(List<PluginConfig> pluginConfigs);

	/**
	 * 获取存储插件
	 * 
	 * @return 存储插件
	 */
	List<StoragePlugin> getStoragePlugins();

	/**
	 * 获取存储插件
	 * 
	 * @param isEnabled
	 *            是否启用
	 * @return 存储插件
	 */
	List<StoragePlugin> getStoragePlugins(boolean isEnabled);

	/**
	 * 获取存储插件
	 * 
	 * @param id
	 *            ID
	 * @return 存储插件
	 */
	StoragePlugin getStoragePlugin(String id);

}