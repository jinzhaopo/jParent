
package com.nt.framework.config.freemarker;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.nt.framework.Setting;
import com.nt.framework.util.ApplicationContextHelpers;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: FreemarkerConfig
 * @Description: freemarker 配置文件
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月30日 下午8:58:46
 */
@Configuration
public class FreemarkerConfig {

	@Autowired
	private FreeMarkerProperties freeMarkerProperties;

	/**
	 * 
	 * @Title: getFreeMarkerConfigurer
	 * @Description: 获取freemarker的配置信息
	 * @return
	 * @return: FreeMarkerConfigurer
	 */
	@Bean("freeMarkerConfigurer")
	public FreeMarkerConfigurer getFreeMarkerConfigurer() {
		Setting setting = SettingUtils.getSetting();
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPaths(setting.getTemplateLoaderPaths());
		freeMarkerConfigurer.setPreferFileSystemAccess(this.freeMarkerProperties.isPreferFileSystemAccess());


		Properties settings = new Properties();
		settings.putAll(freeMarkerProperties.getSettings());
		settings.put("defaultEncoding", setting.getEncoding());
		settings.put("url_escaping_charset", setting.getUrlEscapingCharset());
		settings.put("locale", setting.getLocale());
		settings.put("template_update_delay", setting.getUpdateDelay());
		settings.put("tag_syntax", "auto_detect");
		settings.put("whitespace_stripping", "true");
		settings.put("classic_compatible", "true");
		settings.put("number_format", setting.getNumberFormat());
		settings.put("boolean_format", setting.getBooleanFormat());
		settings.put("datetime_format", setting.getDateTimeFormat());
		settings.put("date_format", setting.getDateFormat());
		settings.put("time_format", setting.getTimeFormat());
		//settings.put("auto_import", setting.getAutoImport());不导入标签
		settings.put("object_wrapper", "freemarker.ext.beans.BeansWrapper");
		freeMarkerConfigurer.setFreemarkerSettings(settings);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("base", ApplicationContextHelpers.getContentPath());
		freeMarkerConfigurer.setFreemarkerVariables(variables);
		return freeMarkerConfigurer;
	}
}
