package com.nt.framework.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nt.framework.annotation.validation.RegexFieldValidate;
import com.nt.framework.annotation.validation.RequiredFieldValidate;
import com.nt.framework.annotation.validation.RequiredStringValidate;
import com.nt.framework.annotation.validation.ValidationBundle;

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
}
