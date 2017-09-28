package com.nt.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @ClassName: SpringUtils
 * @Description: springUtils工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年8月31日 下午2:19:39
 */
@Component
public class SpringUtils implements DisposableBean, ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * 
	 * @Title: destroy
	 * @Description: 销毁对象
	 * @throws Exception
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		applicationContext = null;

	}

	/**
	 * 
	 * @Title: getBean
	 * @Description: 获取spring中的bean
	 * @param name
	 *            bean的名称
	 * 
	 * @return
	 * @return: Object
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	/**
	 * 
	 * @Title: getBean
	 * @Description: 获取spring中的bean
	 * @param name
	 *            bean的名称
	 * @param type
	 *            获取的类型
	 * @return
	 * @return: Object
	 */
	public static <T> T getBean(String name, Class<T> type) {
		return applicationContext.getBean(name, type);
	}

	/**
	 * 获取applicationContext
	 * 
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	private SpringUtils() {

	}

}
