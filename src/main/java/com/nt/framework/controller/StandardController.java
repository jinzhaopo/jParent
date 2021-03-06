package com.nt.framework.controller;

import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.druid.support.json.JSONUtils;
import com.nt.framework.DateEditor;
import com.nt.framework.constants.MessageConst;
import com.nt.framework.service.RSAService;
import com.nt.framework.servlet.Message;
import com.nt.framework.util.ApplicationContextHelpers;
import com.nt.framework.util.SpringUtils;

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
		return successMessage(MessageConst.MESSAGE_SUCCESS_SAVE);
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
		return successMessage(MessageConst.MESSAGE_SUCCESS_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: successMessage4Delete
	 * @Description: 删除成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Delete() {
		return successMessage(MessageConst.MESSAGE_SUCCESS_DELETE);
	}

	/**
	 * 
	 * @Title: successMessage4Delete
	 * @Description: 删除成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Delete(Object data) {
		return successMessage(MessageConst.MESSAGE_SUCCESS_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: successMessage4Update
	 * @Description: 更新成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Update() {
		return successMessage(MessageConst.MESSAGE_SUCCESS_UPDATE);
	}

	/**
	 * 
	 * @Title: successMessage4Update
	 * @Description: 更新成功
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Update(Object data) {
		return successMessage(MessageConst.MESSAGE_SUCCESS_UPDATE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Save
	 * @Description: 新增警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Save() {
		return warnMessage(MessageConst.MESSAGE_WARN_SAVE);
	}

	/**
	 * 
	 * @Title: warnMessage4Save
	 * @Description: 新增警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Save(Object data) {
		return warnMessage(MessageConst.MESSAGE_WARN_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Delete
	 * @Description: 删除警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Delete() {
		return warnMessage(MessageConst.MESSAGE_WARN_DELETE);
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
		return warnMessage(MessageConst.MESSAGE_WARN_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: warnMessage4Update
	 * @Description: 更新警告
	 * @return
	 * @return: Message
	 */
	public Message warnMessage4Update() {
		return warnMessage(MessageConst.MESSAGE_WARN_UPDATE);
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
		return warnMessage(MessageConst.MESSAGE_WARN_UPDATE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Save
	 * @Description: 添加错误消息
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Save() {
		return errorMessage(MessageConst.MESSAGE_ERROR_SAVE);
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
		return errorMessage(MessageConst.MESSAGE_ERROR_SAVE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Delete
	 * @Description: 删除错误
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Delete() {
		return errorMessage(MessageConst.MESSAGE_ERROR_DELETE);
	}

	/**
	 * 
	 * @Title: errorMessage4Delete
	 * @Description: 删除错误
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Delete(Object data) {
		return errorMessage(MessageConst.MESSAGE_ERROR_DELETE, null, data);
	}

	/**
	 * 
	 * @Title: errorMessage4Update
	 * @Description: 更新失败
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Update() {
		return errorMessage(MessageConst.MESSAGE_ERROR_UPDATE);
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
		return errorMessage(MessageConst.MESSAGE_ERROR_UPDATE, null, data);
	}

	/**
	 * 
	 * @Title: successMessage4Option
	 * @Description: 操作成功的提示
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Option() {
		return successMessage(MessageConst.MESSAGE_SUCCESS_OPERATION);
	}

	/**
	 * 
	 * @Title: successMessage4Option
	 * @Description: 操作成功的提示
	 * @param obj
	 * @return
	 * @return: Message
	 */
	public Message successMessage4Option(Object obj) {
		return successMessage(MessageConst.MESSAGE_SUCCESS_OPERATION, null, obj);
	}

	/**
	 * 
	 * @Title: errorMessage4Option
	 * @Description: 操作失败的提示
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Option() {
		return errorMessage(MessageConst.MESSAGE_ERROR_OPERATION);
	}

	/**
	 * 
	 * @Title: errorMessage4Option
	 * @Description: 操作失败的提示
	 * @param obj
	 * @return
	 * @return: Message
	 */
	public Message errorMessage4Option(Object obj) {
		return errorMessage(MessageConst.MESSAGE_ERROR_OPERATION, null, obj);
	}

	/**
	 * 
	 * @Title: dealJsonP
	 * @Description: 处理ajax跨域请求的封装数据
	 * @param json
	 * @return
	 * @return: String
	 */
	public String dealJSONP(String json) {
		String callback = ApplicationContextHelpers.getRequest().getParameter("callback");
		if (StringUtils.isNotBlank(callback)) {
			return callback + "(" + json + ")";
		} else {
			return json;
		}
	}

	/**
	 * 
	 * @Title: dealJSONP
	 * @Description: 处理ajax跨域请求的封装数据
	 * @param message
	 * @return
	 * @return: String
	 */
	public String dealJSONP(Message message) {
		return dealJSONP(JSONUtils.toJSONString(message));
	}

	/**
	 * 
	 * @Title: publicKey
	 * @Description: 公钥
	 * @param request
	 * @return
	 * @return: Map<String,String>
	 */
	public Map<String, String> publicKey(HttpServletRequest request) {
		RSAService rsaService = (RSAService) SpringUtils.getBean("rsaServiceImpl");
		RSAPublicKey publicKey = rsaService.generateKey(request);
		Map<String, String> data = new HashMap<String, String>();
		data.put("modulus", Base64.encodeBase64String(publicKey.getModulus().toByteArray()));
		data.put("exponent", Base64.encodeBase64String(publicKey.getPublicExponent().toByteArray()));
		return data;
	}
}
