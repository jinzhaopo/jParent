package com.nt.framework.annotation.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: RequiredFieldValidator
 * @Description: 对象非空验证器
 * @author: Administrator
 * @date: 2015年5月10日 下午1:58:16
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredFieldValidator {
	/**
	 * 
	 * @Title: message
	 * @Description: 提示消息
	 * @return
	 * @return: String
	 */
	String message() default "";

	String key() default "";

	/**
	 * 
	 * @Title: fieldName
	 * @Description: 字段名称
	 * @return
	 * @return: String
	 */
	String fieldName() default "";

}
