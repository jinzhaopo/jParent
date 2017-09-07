package com.nt.framework.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: SettingProperties
 * @Description: 获取参数的配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年8月31日 下午3:21:51
 */
@ConfigurationProperties
@PropertySource(value = "classpath:Setting.properties", encoding = "UTF-8")
@Component
public class SettingProperties {

	/**
	 * 项目的名称
	 */
	@Value("${app.name}")
	private String appName;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
