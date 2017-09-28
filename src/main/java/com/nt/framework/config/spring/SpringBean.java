package com.nt.framework.config.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.nt.framework.Setting;
import com.nt.framework.annotation.validation.RegexFieldValidate;
import com.nt.framework.annotation.validation.RequiredFieldValidate;
import com.nt.framework.annotation.validation.RequiredStringValidate;
import com.nt.framework.annotation.validation.ValidationBundle;
import com.nt.framework.util.ApplicationContextHelpers;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: SpringBean
 * @Description: 加载springBean类似是xml中的spring配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 上午10:18:29
 */
@Configuration
public class SpringBean {

	@Autowired
	private FreeMarkerProperties freeMarkerProperties;

	/**
	 * 
	 * @Title: getValidationBundle
	 * @Description: 将验证插件注册到spring中
	 * @return
	 * @return: ValidationBundle
	 */
	@Bean("validationBundle")
	public ValidationBundle getValidationBundle() {
		ValidationBundle vb = new ValidationBundle();
		vb.registerValidates(new RegexFieldValidate());
		vb.registerValidates(new RequiredFieldValidate());
		vb.registerValidates(new RequiredStringValidate());

		return vb;

	}

	/**
	 * 
	 * @Title: getTaskExecutor
	 * @Description: 获取线程池
	 * @return
	 * @return: ThreadPoolTaskExecutor
	 */
	@Bean("taskExecutor")
	public ThreadPoolTaskExecutor getTaskExecutor() {
		ThreadPoolTaskExecutor tpte = new ThreadPoolTaskExecutor();
		tpte.setCorePoolSize(SettingUtils.getSetting().getCorePoolSize());
		tpte.setMaxPoolSize(SettingUtils.getSetting().getMaxPoolSize());
		tpte.setQueueCapacity(SettingUtils.getSetting().getQueueCapacity());
		tpte.setKeepAliveSeconds(SettingUtils.getSetting().getKeepAliveSeconds());
		return tpte;
	}

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
		settings.put("auto_import", setting.getAutoImport());
		settings.put("object_wrapper", "freemarker.ext.beans.BeansWrapper");
		freeMarkerConfigurer.setFreemarkerSettings(settings);

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("base", ApplicationContextHelpers.getContentPath());
		freeMarkerConfigurer.setFreemarkerVariables(variables);
		return freeMarkerConfigurer;
	}
}
