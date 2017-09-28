package com.nt.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.framework.mapper.PluginConfigMapper;
import com.nt.framework.model.PluginConfig;
import com.nt.framework.page.SearchFilter;
import com.nt.framework.service.PluginConfigService;
import com.nt.framework.tkMapper.MyMapper;

import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @ClassName: PluginConfigServiceImpl
 * @Description: 插件配置---serviceImpl
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午11:06:43
 */
@Service
@Transactional(readOnly = true)
public class PluginConfigServiceImpl extends BaseServiceImpl<PluginConfig> implements PluginConfigService {

	@Autowired
	private PluginConfigMapper pluginConfigMapper;

	@Autowired
	protected void setMapper(PluginConfigMapper mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 
	 * @Title: pluginIdExists
	 * @Description: 判断插件ID是否存在
	 * @param pluginId
	 * @return
	 * @see com.nt.framework.service.PluginConfigService#pluginIdExists(java.lang.String)
	 */
	@Override
	public boolean pluginIdExists(String pluginId) {
		int count = getCount(SearchFilter.eq("pluginId", pluginId));
		return count > 0;
	}

	/**
	 * 
	 * @Title: findByPluginId
	 * @Description: 根据插件ID查找插件配置
	 * @param pluginId
	 * @return
	 * @see com.nt.framework.service.PluginConfigService#findByPluginId(java.lang.String)
	 */
	@Override
	public PluginConfig findByPluginId(String pluginId) {
		return get("pluginId", pluginId);
	}
}
