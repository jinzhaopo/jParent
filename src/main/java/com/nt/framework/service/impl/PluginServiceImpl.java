package com.nt.framework.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.framework.model.PluginConfig;
import com.nt.framework.page.SearchFilter;
import com.nt.framework.plugin.StoragePlugin;
import com.nt.framework.service.PluginConfigService;
import com.nt.framework.service.PluginService;
import com.nt.framework.util.SpringUtils;

/**
 * 
 * @ClassName: PluginServiceImpl
 * @Description: Service - 插件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 下午4:16:41
 */
@Service
public class PluginServiceImpl implements PluginService {

	@Autowired
	private PluginConfigService pluginConfigService;

	/**
	 * 
	 * @Title: getStoragePluginsByPluginConfigs
	 * @Description: 将插件的配置转换成插件
	 * @param pluginConfigs
	 * @return
	 * @see com.nt.framework.service.PluginService#getStoragePluginsByPluginConfigs(java.util.List)
	 */
	@Override
	public List<StoragePlugin> getStoragePluginsByPluginConfigs(List<PluginConfig> pluginConfigs) {
		List<StoragePlugin> storagePlugins = new ArrayList<StoragePlugin>();
		for (PluginConfig pluginConfig : pluginConfigs) {
			StoragePlugin storagePlugin = (StoragePlugin) SpringUtils.getBean(pluginConfig.getPluginId());
			storagePlugins.add(storagePlugin);
		}
		return storagePlugins;
	}

	/**
	 * 
	 * @Title: getStoragePlugins
	 * @Description: 获取存储插件
	 * @return
	 * @see com.nt.framework.service.PluginService#getStoragePlugins()
	 */
	public List<StoragePlugin> getStoragePlugins() {
		List<PluginConfig> pluginConfigs = pluginConfigService.getList(SearchFilter.in("pluginId", StoragePlugin.KEYS));
		List<StoragePlugin> storagePluginsByPluginConfigs = getStoragePluginsByPluginConfigs(pluginConfigs);
		Collections.sort(storagePluginsByPluginConfigs);
		return storagePluginsByPluginConfigs;
	}

	/**
	 * 
	 * @Title: getStoragePlugins
	 * @Description: 获取存储插件
	 * @param isEnabled
	 * @return
	 * @see com.nt.framework.service.PluginService#getStoragePlugins(boolean)
	 */
	public List<StoragePlugin> getStoragePlugins(final boolean isEnabled) {
		List<StoragePlugin> result = new ArrayList<StoragePlugin>();
		CollectionUtils.select(getStoragePlugins(), new Predicate() {
			public boolean evaluate(Object object) {
				StoragePlugin storagePlugin = (StoragePlugin) object;
				return storagePlugin.getIsEnabled() == isEnabled;
			}
		}, result);
		Collections.sort(result);
		return result;
	}

	/**
	 * 
	 * @Title: getStoragePlugin
	 * @Description: 获取存储插件
	 * @param id
	 * @return
	 * @see com.nt.framework.service.PluginService#getStoragePlugin(java.lang.String)
	 */
	public StoragePlugin getStoragePlugin(String id) {
		PluginConfig pluginConfig = pluginConfigService.get("pluginId", id);
		if (pluginConfig == null) {
			return null;
		} else {
			return (StoragePlugin) SpringUtils.getBean(pluginConfig.getPluginId());
		}
	}

}