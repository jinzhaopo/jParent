package com.nt.framework.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nt.framework.servlet.Message;
import com.nt.framework.util.FastJsonUtils;
import com.nt.framework.util.ResponseUtils;

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

	/**
	 * 
	 * @Title: defaultErrorHandler
	 * @Description: 异常处理
	 * @param req
	 * @param e
	 * @return: void
	 */
	@ExceptionHandler(value = Exception.class)
	public void defaultErrorHandler(HttpServletRequest req, Exception e, HttpServletResponse response) {
		System.err.println(e);
		Message message = Message.error("系统错误!");
		StackTraceElement[] stacks = e.getStackTrace();
		for (int i = 0; i < stacks.length; i++) {
			System.err.println("file name:" + stacks[i].getFileName());
			System.err.println("class:" + stacks[i].getClassName());
			System.err.println("method name:" + stacks[i].getMethodName());
			System.err.println("Line No:" + stacks[i].getLineNumber());
			System.err.println("--------------------");
		}
		ResponseUtils.renderJSON(FastJsonUtils.toJSONString(message), response);
	}
}
