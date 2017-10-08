package com.nt.framework.annotation.validation;

/**
 * 
 * @ClassName: IntRangeFieldValidator
 * @Description: int验证
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月6日 下午2:10:08
 */
public @interface IntRangeFieldValidator {
	String min() default "";

	String max() default "";

	String message() default "";

	String fieldName() default "";
}
