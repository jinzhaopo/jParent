package com.nt.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.framework.mapper.PluginConfigAttributeMapper;
import com.nt.framework.model.PluginConfigAttribute;
import com.nt.framework.page.SearchFilter;
import com.nt.framework.service.PluginConfigAttributeService;

/**
 * 
 * @ClassName: PluginConfigAttributeServiceImpl
 * @Description: 插件配置属性---serviceImpl
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午11:13:25
 */
@Service
@Transactional(readOnly = true)
public class PluginConfigAttributeServiceImpl extends BaseServiceImpl<PluginConfigAttribute> implements PluginConfigAttributeService {

	@Autowired
	private PluginConfigAttributeMapper pluginConfigAttributeMapper;

	@Autowired
	protected void setMapper(PluginConfigAttributeMapper mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 
	 * @Title: getByPluginConfigIdAndName
	 * @Description: 根据插件配置的id和Name进行查找
	 * @param pluginConfigId
	 * @param name
	 * @return
	 * @see com.nt.framework.service.PluginConfigAttributeService#getByPluginConfigIdAndName(java.lang.Long,
	 *      java.lang.String)
	 */
	@Override
	public PluginConfigAttribute getByPluginConfigIdAndName(Long pluginConfigId, String name) {
		List<PluginConfigAttribute> list = getList(SearchFilter.eq("pluginConfigId", pluginConfigId), SearchFilter.eq("name", name));
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
