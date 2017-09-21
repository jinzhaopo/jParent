package com.nt.framework.annotation.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @ClassName: RegexFieldValidator
 * @Description: 正则验证
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月21日 下午2:47:43
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RegexFieldValidator {
	/**
	 * 
	 * @Title: message
	 * @Description: 提示消息
	 * @return
	 * @return: String
	 */
	String message() default "";

	String key() default "";

	String fieldName() default "";

	String expression();
}
