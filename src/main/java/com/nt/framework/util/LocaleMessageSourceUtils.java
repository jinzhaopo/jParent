package com.nt.framework.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * 
 * @ClassName: LocaleMessageSourceUtils
 * @Description: 国际化解析器工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 上午9:53:27
 */
public class LocaleMessageSourceUtils {

	/**
	 * 
	 * @Title: getMessage
	 * @Description: 获取国际化信息
	 * @param code
	 *            对应messages配置的key
	 * @return
	 * @return: String
	 */
	public static String getMessage(String code) {
		return getMessage(code, null);
	}

	/**
	 * 
	 * @Title: getMessage
	 * @Description: TODO
	 * @param code
	 *            对应messages配置的key.
	 * @param args
	 *            数组参数
	 * @return
	 * @return: String
	 */
	public static String getMessage(String code, Object[] args) {
		return getMessage(code, args, code);
	}

	/**
	 * 
	 * @Title: getMessage
	 * @Description: 获取国际化参数
	 * @param code
	 *            对应messages配置的key.
	 * @param args
	 *            数组参数
	 * @param defaultMessage
	 *            没有设置key的时候的默认值.
	 * @return
	 * @return: String
	 */
	public static String getMessage(String code, Object[] args, String defaultMessage) {
		Locale locale = LocaleContextHolder.getLocale();
		MessageSource messageSource = (MessageSource) SpringUtils.getBean("messageSource", MessageSource.class);
		return messageSource.getMessage(code, args, defaultMessage, locale);
	}

}
