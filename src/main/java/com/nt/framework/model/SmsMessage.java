package com.nt.framework.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.nt.framework.model.enumModel.MessageStatus;
import com.nt.framework.model.enumModel.MessageType;

/**
 * 
 * @ClassName: SmsMessage
 * @Description: 短信
 * @author: zhaopo
 * @date: 2016年11月28日 下午3:25:01
 */
@Table(name = "s_sms_message")
public class SmsMessage extends BaseEntity {

	private static final long serialVersionUID = -6256278762614282578L;
	/**
	 * 短信号码
	 */
	@Column(name = "sms_number")
	private String smsNumber;
	/**
	 * 短信内容
	 */
	@Column(name = "sms_content")
	private String smsContent;
	/**
	 * 发送时间
	 */
	@Column(name = "send_time")
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;
	/**
	 * 流水号
	 */
	private String sn;
	/**
	 * 备注
	 */
	private String description;
	/**
	 * 状态
	 */
	private MessageStatus status;
	/**
	 * 短信类型
	 */
	private MessageType type;

	public String getSmsNumber() {
		return smsNumber;
	}

	public void setSmsNumber(String smsNumber) {
		this.smsNumber = smsNumber;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MessageStatus getStatus() {
		return status;
	}

	public void setStatus(MessageStatus status) {
		this.status = status;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

}
