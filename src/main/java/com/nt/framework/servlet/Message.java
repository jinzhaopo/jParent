package com.nt.framework.servlet;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nt.framework.enumType.MessageTypeEnum;
import com.nt.framework.util.LocaleMessageSourceUtils;

/**
 * 
 * @ClassName: Message
 * @Description: 请求消息
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月8日 上午10:33:12
 */
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Message implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 2160337372096151432L;
	/**
	 * 消息类型
	 */
	private MessageTypeEnum type;
	/**
	 * 内容提示
	 */
	private String content;
	/**
	 * 数据
	 */
	private Object data;

	public Message(MessageTypeEnum type, String content, Object args[]) {
		this.type = type;
		this.content = LocaleMessageSourceUtils.getMessage(content, args);
	}

	public Message(MessageTypeEnum type, String content, Object args[], Object data) {
		this.data = data;
		this.type = type;
		this.content = LocaleMessageSourceUtils.getMessage(content, args);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 成功信息
	 * @param content
	 *            内容
	 * @return
	 * @return: Message
	 */
	public static Message success(String content) {
		return new Message(MessageTypeEnum.SUCCESS, content, null);
	}

	/**
	 * 
	 * @Title: warn
	 * @Description: 警告信息
	 * @param content
	 *            内容
	 * @return
	 * @return: Message
	 */
	public static Message warn(String content) {
		return new Message(MessageTypeEnum.WARN, content, null);
	}

	/**
	 * 
	 * @Title: error
	 * @Description: 错误信息
	 * @param content
	 *            信息内容
	 * @return
	 * @return: Message
	 */
	public static Message error(String content) {
		return new Message(MessageTypeEnum.ERROR, content, null);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 成功信息
	 * @param content
	 *            内容
	 * @param args
	 *            内容赋值
	 * @return
	 * @return: Message
	 */
	public static Message success(String content, Object args[]) {
		return new Message(MessageTypeEnum.SUCCESS, content, args);
	}

	/**
	 * 
	 * @Title: warn
	 * @Description: 警告信息
	 * @param content
	 *            内容
	 * @param args
	 *            内容赋值
	 * @return
	 * @return: Message
	 */
	public static Message warn(String content, Object args[]) {
		return new Message(MessageTypeEnum.WARN, content, args);
	}

	/**
	 * 
	 * @Title: error
	 * @Description: 错误信息
	 * @param content
	 *            信息内容
	 * @param args
	 *            内容赋值
	 * @return
	 * @return: Message
	 */
	public static Message error(String content, Object args[]) {
		return new Message(MessageTypeEnum.ERROR, content, args);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 成功信息
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message success(Object data) {
		return new Message(MessageTypeEnum.SUCCESS, null, null, data);
	}

	/**
	 * 
	 * @Title: warn
	 * @Description: 警告信息
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message warn(Object data) {
		return new Message(MessageTypeEnum.WARN, null, null, data);
	}

	/**
	 * 
	 * @Title: error
	 * @Description: 错误信息
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message error(Object data) {
		return new Message(MessageTypeEnum.ERROR, null, null, data);
	}

	/**
	 * 
	 * @Title: success
	 * @Description: 成功信息
	 * @param content
	 *            内容
	 * @param args
	 *            内容赋值
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message success(String content, Object args[], Object data) {
		return new Message(MessageTypeEnum.SUCCESS, content, args, data);
	}

	/**
	 * 
	 * @Title: warn
	 * @Description: 警告信息
	 * @param content
	 *            内容
	 * @param args
	 *            内容赋值
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message warn(String content, Object args[], Object data) {
		return new Message(MessageTypeEnum.WARN, content, args, data);
	}

	/**
	 * 
	 * @Title: error
	 * @Description: 错误信息
	 * @param content
	 *            内容
	 * @param args
	 *            内容赋值
	 * @param data
	 *            返回数据
	 * @return
	 * @return: Message
	 */
	public static Message error(String content, Object args[], Object data) {
		return new Message(MessageTypeEnum.ERROR, content, args, data);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Message() {
		super();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MessageTypeEnum getType() {
		return type;
	}

	public void setType(MessageTypeEnum type) {
		this.type = type;
	}

}
