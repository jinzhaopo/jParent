package com.nt.framework.util;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * @ClassName: ApplicationContentHelpers
 * @Description: servlet上下文工具类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月27日 下午3:26:47
 */
public class ApplicationContextHelpers implements ServletContextAware {

	private static ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}

	/**
	 * 获取上下文
	 * 
	 * @return
	 */
	public static ServletContext getContext() {
		return servletContext;
	}

	/**
	 * 获取ip
	 * 
	 * @return
	 */
	public static String getRemoteIp() {
		HttpServletRequest request = getRequest();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 
	 * @Title: getSessionAttr
	 * @Description: 获取session
	 * @param key
	 * @return
	 * @return: Object
	 */
	public static Object getSessionAttr(String key) {
		HttpSession session = getRequest().getSession(false);
		if (session == null) {
			return null;
		} else {
			return session.getAttribute(key);
		}
	}

	/**
	 * 
	 * @Title: getCookie
	 * @Description: 获取cookie
	 * @param name
	 * @return
	 * @return: Cookie
	 */
	public static Cookie getCookie(String name) {
		Cookie[] cookies = getRequest().getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @Title: getSessionId
	 * @Description: 获取sessionId
	 * @param isCreate
	 * @return
	 * @return: String
	 */
	public static String getSessionId(boolean isCreate) {
		HttpSession session = getRequest().getSession(isCreate);
		if (session == null) {
			return null;
		} else {
			return session.getId();
		}
	}

	/**
	 * 
	 * @Title: setSessionAttr
	 * @Description: 设置session中的值
	 * @param key
	 * @param value
	 * @return: void
	 */
	public static void setSessionAttr(String key, Object value) {
		HttpSession session = getRequest().getSession(false);
		if (session == null) {
			session = getRequest().getSession(true);
		}
		session.setAttribute(key, value);
	}

	/**
	 * 
	 * @Title: getAppRealPath
	 * @Description: 获取真实的路径
	 * @param path
	 * @return
	 * @return: String
	 */
	public static String getAppRealPath(String path) {
		return servletContext.getRealPath(path);
	}

	/**
	 * 
	 * @Title: getContentPath
	 * @Description: 获取项目的根路径
	 * @return
	 * @return: String
	 */
	public static String getContentPath() {
		return servletContext.getContextPath();
	}

	/**
	 * 
	 * @Title: removeAttribute
	 * @Description: 移除session中的值
	 * @param key
	 * @return: void
	 */
	public static void removeAttribute(String key) {
		HttpSession session = getRequest().getSession(false);
		session.removeAttribute(key);
	}

	/**
	 * 
	 * @Title: getRequest
	 * @Description: 获取request
	 * @return
	 * @return: HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
