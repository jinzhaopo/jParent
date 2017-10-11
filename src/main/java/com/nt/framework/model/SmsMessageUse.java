package com.nt.framework.model;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 
 * @ClassName: SmsMessageUse
 * @Description: 记录验证短信获取验证码的作用
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月10日 下午7:39:17
 */
@Table(name = "nt_smsMessageUse")
public class SmsMessageUse extends SmsMessage {

	private static final long serialVersionUID = -5855018947607543273L;
	/**
	 * 加上时间的验证码
	 */
	@Column(name = "verify_code", nullable = false)
	private String verifyCode;
	/**
	 * 业务关键字,通过这个去查找业务
	 */
	@Column(name = "business_key", nullable = false)
	private String businessKey;
	/**
	 * 判断验证码是否使用过
	 */
	@Column(nullable = false)
	private Boolean used;

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}

}
