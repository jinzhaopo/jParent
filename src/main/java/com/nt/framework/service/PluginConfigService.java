package com.nt.framework.service;

import com.nt.framework.model.PluginConfig;

/**
 * 
 * @ClassName: PluginConfigService
 * @Description: 插件配置接口---service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午11:03:14
 */
public interface PluginConfigService extends BaseService<PluginConfig> {
	/**
	 * 判断插件ID是否存在
	 * 
	 * @param pluginId
	 *            插件ID
	 * @return 插件ID是否存在
	 */
	boolean pluginIdExists(String pluginId);

	/**
	 * 根据插件ID查找插件配置
	 * 
	 * @param pluginId
	 *            插件ID
	 * @return 插件配置，若不存在则返回null
	 */
	PluginConfig findByPluginId(String pluginId);
}
