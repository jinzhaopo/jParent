package com.nt.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 * @ClassName: GlobalDefaultExceptionHandler
 * @Description: 全局异常
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年8月31日 下午2:46:00
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e) {
	}
}
