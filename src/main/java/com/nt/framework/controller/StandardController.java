package com.nt.framework.controller;

import java.util.Date;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.nt.framework.Constant;
import com.nt.framework.DateEditor;
import com.nt.framework.servlet.Message;

/**
 * 
 * @ClassName: StandardController
 * @Description: 标准的Controller---baseController的父类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月26日 上午9:51:23
 */
public abstract class StandardController {

	/**
	 * 
	 * @Title: initBinder
	 * @Description: 数据处理Date
	 * @param webdatabinder
	 * @return: void
	 */
	@InitBinder
	protected void initBinder(WebDataBinder webdatabinder) {
		webdatabinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		webdatabinder.registerCustomEditor(Date.class, new DateEditor(true));
	}

	/**
	 * 
	 * @Title: successMessage
	 * @Description: 获取成功的提示消息
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message successMessage(Object data) {
		return Message.success(data);
	}

	/**
	 * 
	 * @Title: successMessage
	 * @Description: 获取成功的提示消息
	 * @param content
	 * @return
	 * @return: Message
	 */
	public Message successMessage(String content) {
		return Message.success(content);
	}

	/**
	 * 
	 * @Title: successMessage
	 * @Description: 获取成功的提示消息
	 * @param content
	 * @param args
	 * @return
	 * @return: Message
	 */
	public Message successMessage(String content, Object[] args) {
		return Message.success(content, args);

	}

	/**
	 * 
	 * @Title: successMessage
	 * @Description: 获取成功的提示消息
	 * @param content
	 * @param args
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message successMessage(String content, Object[] args, Object data) {
		return Message.success(content, args, data);
	}

	/**
	 * 
	 * @Title: warnMessage
	 * @Description: 获取警告的提示消息
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message warnMessage(Object data) {
		return Message.warn(data);
	}

	/**
	 * 
	 * @Title: warnMessage
	 * @Description: 获取警告的提示消息
	 * @param content
	 * @return
	 * @return: Message
	 */
	public Message warnMessage(String content) {
		return Message.warn(content);
	}

	/**
	 * 
	 * @Title: warnMessage
	 * @Description: 获取警告的提示消息
	 * @param content
	 * @param args
	 * @return
	 * @return: Message
	 */
	public Message warnMessage(String content, Object[] args) {
		return Message.warn(content, args);

	}

	/**
	 * 
	 * @Title: warnMessage
	 * @Description: 获取警告的提示消息
	 * @param content
	 * @param args
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message warnMessage(String content, Object[] args, Object data) {
		return Message.warn(content, args, data);
	}

	/**
	 * 
	 * @Title: errorMessage
	 * @Description: 获取错误的提示消息
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message errorMessage(Object data) {
		return Message.error(data);
	}

	/**
	 * 
	 * @Title: errorMessage
	 * @Description: 获取错误的提示消息
	 * @param content
	 * @return
	 * @return: Message
	 */
	public Message errorMessage(String content) {
		return Message.error(content);
	}

	/**
	 * 
	 * @Title: errorMessage
	 * @Description: 获取错误的提示消息
	 * @param content
	 * @param args
	 * @return
	 * @return: Message
	 */
	public Message errorMessage(String content, Object[] args) {
		return Message.error(content, args);

	}

	/**
	 * 
	 * @Title: errorMessage
	 * @Description: 获取错误的提示消息
	 * @param content
	 * @param args
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message errorMessage(String content, Object[] args, Object data) {
		return Message.error(content, args, data);
	}

	/**
	 * 
	 * @Title: successMessage4save
	 * @Description: 添加成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Save() {
		return successMessage(Constant.MESSAGE_SUCCESS_SAVE);
	}

	/**
	 * 
	 * @Title: successMessage4Save
	 * @Description: 添加成功
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Save(Object data) {
		return successMessage(Constant.MESSAGE_SUCCESS_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: successMessage4Delete
	 * @Description: 删除成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Delete() {
		return successMessage(Constant.MESSAGE_SUCCESS_DELETE);
	}

	/**
	 * 
	 * @Title: successMessage4Delete
	 * @Description: 删除成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Delete(Object data) {
		return successMessage(Constant.MESSAGE_SUCCESS_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: successMessage4Update
	 * @Description: 更新成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Update() {
		return successMessage(Constant.MESSAGE_SUCCESS_UPDATE);
	}

	/**
	 * 
	 * @Title: successMessage4Update
	 * @Description: 更新成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Update(Object data) {
		return successMessage(Constant.MESSAGE_SUCCESS_UPDATE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Save
	 * @Description: 新增警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Save() {
		return warnMessage(Constant.MESSAGE_WARN_SAVE);
	}

	/**
	 * 
	 * @Title: warnMessage4Save
	 * @Description: 新增警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Save(Object data) {
		return warnMessage(Constant.MESSAGE_WARN_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Delete
	 * @Description: 删除警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Delete() {
		return warnMessage(Constant.MESSAGE_WARN_DELETE);
	}

	/**
	 * 
	 * @Title: warnMessage4Delete
	 * @Description: 删除警告
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Delete(Object data) {
		return warnMessage(Constant.MESSAGE_WARN_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Update
	 * @Description: 更新警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Update() {
		return warnMessage(Constant.MESSAGE_WARN_UPDATE);
	}

	/**
	 * 
	 * @Title: warnMessage4Update
	 * @Description: 更新警告
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Update(Object data) {
		return warnMessage(Constant.MESSAGE_WARN_UPDATE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Save
	 * @Description: 添加错误消息
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Save() {
		return errorMessage(Constant.MESSAGE_ERROR_SAVE);
	}

	/**
	 * 
	 * @Title: errorMessage4Save
	 * @Description: 新增错误
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Save(Object data) {
		return errorMessage(Constant.MESSAGE_ERROR_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Delete
	 * @Description: 删除错误
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Delete() {
		return errorMessage(Constant.MESSAGE_ERROR_DELETE);
	}

	/**
	 * 
	 * @Title: errorMessage4Delete
	 * @Description: 删除错误
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Delete(Object data) {
		return errorMessage(Constant.MESSAGE_ERROR_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Update
	 * @Description: 更新失败
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Update() {
		return errorMessage(Constant.Message_ERROR_UPDATE);
	}

	/**
	 * 
	 * @Title: errorMessage4Update
	 * @Description: 更新失败
	 * @param data
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Update(Object data) {
		return errorMessage(Constant.Message_ERROR_UPDATE, null, data);
	}
}
