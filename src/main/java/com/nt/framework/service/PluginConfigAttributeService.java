package com.nt.framework.service;

import com.nt.framework.model.PluginConfigAttribute;

/**
 * 
 * @ClassName: PluginConfigAttributeService
 * @Description: 插件属性配置接口---service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午11:04:26
 */
public interface PluginConfigAttributeService extends BaseService<PluginConfigAttribute> {
	/**
	 * 
	 * @Title: getByPluginConfigIdAndName
	 * @Description: 根据插件配置的id和name查找
	 * @param pluginConfigId
	 * @param name
	 * @return
	 * @return: PluginConfigAttribute
	 */
	PluginConfigAttribute getByPluginConfigIdAndName(Long pluginConfigId, String name);
}
