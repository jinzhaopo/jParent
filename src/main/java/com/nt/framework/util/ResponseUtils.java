package com.nt.framework.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: ResponseUtil
 * @Description: response工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年5月25日 下午1:35:24
 */
public class ResponseUtils {
	public static final Logger log = LoggerFactory.getLogger(ResponseUtils.class);

	/**
	 * 
	 * @Title: renderText
	 * @Description: 直接输出字符串.
	 * @param text
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderText(String text, HttpServletResponse response) {
		return render(text, "text/plain;charset=UTF-8", response);
	}

	/**
	 * 
	 * @Title: renderHtmlGBK
	 * @Description: 直接输出字符串GBK编码.
	 * @param html
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderHtmlGBK(String html, HttpServletResponse response) {
		return render(html, "text/html;charset=GBK", response);
	}

	/**
	 * 
	 * @Title: renderHtmlUTF8
	 * @Description: 直接输出字符串GBK编码.
	 * @param html
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderHtmlUTF8(String html, HttpServletResponse response) {
		return render(html, "text/html;charset=utf-8", response);
	}

	/**
	 * 
	 * @Title: renderXML
	 * @Description: 直接输出XML.
	 * @param xml
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderXML(String xml, HttpServletResponse response) {
		return render(xml, "text/xml;charset=UTF-8", response);
	}

	/**
	 * 
	 * @Title: renderJSON
	 * @Description: 直接输出JSON.
	 * @param jsonString
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderJSON(String jsonString, HttpServletResponse response) {
		return render(jsonString, "text/json;charset=UTF-8", response);
	}

	/**
	 * 
	 * @Title: renderJSON
	 * @Description: 直接输出JSON.
	 * @param obj
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String renderJSON(Object obj, HttpServletResponse response) {
		return render(FastJsonUtils.toJSONString(obj), "text/json;charset=UTF-8", response);
	}

	/**
	 * 
	 * @Title: render
	 * @Description: 绕过Template,直接输出内容的简便函数.
	 * @param text
	 * @param contentType
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String render(String text, String contentType, HttpServletResponse response) {
		try {
			response.setContentType(contentType);
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(text);
			response.getWriter().flush();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 
	 * @Title: ajaxJsonErrorMessage
	 * @Description: 输出后台 JSON错误消息，返回null
	 * @param message
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String ajaxJsonErrorMessage(String message, HttpServletResponse response) {
		response.setStatus(400);
		response.addHeader("Error-Json", message);
		return ResponseUtils.renderJSON("{error:" + message + "}", response);
	}

	/**
	 * 
	 * @Title: ajaxJsonFrontErrorMessage
	 * @Description: 输出前台JSON错误消息，返回null
	 * @param message
	 * @param response
	 * @return
	 * @return: String
	 */
	public static String ajaxJsonFrontErrorMessage(String message, HttpServletResponse response) {
		response.setStatus(400);
		response.addHeader("errorStatus", "systemError");
		return ResponseUtils.renderJSON("{error:" + message + "}", response);
	}

	/**
	 * 
	 * @Title: setImage
	 * @Description: 设置response以图片的显示输出
	 * @param response
	 * @return: void
	 */
	public static void setImage(HttpServletResponse response) {
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0L);
		response.setContentType("image/jpeg");// 以图片的形式显示
	}
}
