package com.nt.framework.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.nt.framework.interceptor.ValidationInterceptor;

/**
 * 
 * @ClassName: MyWebAppConfigurer
 * @Description: 拦截器
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 下午1:35:11
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(new ValidationInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

}