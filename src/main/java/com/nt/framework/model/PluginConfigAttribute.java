package com.nt.framework.model;

import javax.persistence.Column;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @ClassName: PluginConfigAttribute
 * @Description: 插件的属性(先简单的设计成是key -- value)
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 上午10:09:26
 */
@Table(name = "nt_plugin_config_attribute")
public class PluginConfigAttribute extends PriorityEntity {

	private static final long serialVersionUID = 3614649331519538930L;

	/**
	 * 名称
	 */
	@JsonProperty
	@NotEmpty
	@Length(max = 200)
	@Column(nullable = false)
	private String name;
	/**
	 * 值
	 */
	@JsonProperty
	@NotEmpty
	@Column(nullable = false)
	private String value;

	/***************** link ******************/

	@Column(name = "plugin_config_id", nullable = false)
	private Long pluginConfigId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
