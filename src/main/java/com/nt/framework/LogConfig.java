package com.nt.framework;

import java.io.Serializable;

/**
 * 
 * @ClassName: LogConfig
 * @Description: 日志配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月25日 下午4:00:03
 */
public class LogConfig implements Serializable {

	private static final long serialVersionUID = -1108848647938408402L;

	/** 操作名称 */
	private String operation;

	/** 请求URL */
	private String urlPattern;

	/**
	 * 获取操作名称
	 * 
	 * @return 操作名称
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * 设置操作名称
	 * 
	 * @param operation
	 *            操作名称
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	/**
	 * 获取请求URL
	 * 
	 * @return 请求URL
	 */
	public String getUrlPattern() {
		return urlPattern;
	}

	/**
	 * 设置请求URL
	 * 
	 * @param urlPattern
	 *            请求URL
	 */
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public LogConfig(String operation, String urlPattern) {
		super();
		this.operation = operation;
		this.urlPattern = urlPattern;
	}

}