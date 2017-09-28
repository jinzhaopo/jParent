package com.nt.framework.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 * @ClassName: PluginConfig
 * @Description: 插件配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午10:01:21
 */
@Table(name = "nt_plugin_config")
public class PluginConfig extends PriorityEntity {

	private static final long serialVersionUID = -2437108214499766140L;

	/**
	 * 插件ID
	 */
	@Column(name="plugin_id", nullable = false, updatable = false, unique = true, length = 100)
	private String pluginId;
	/**
	 * 是否启用
	 */
	@Column(nullable = false)
	private Boolean enabled;

	public String getPluginId() {
		return pluginId;
	}

	public void setPluginId(String pluginId) {
		this.pluginId = pluginId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
