package com.nt.framework.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.framework.mapper.SmsMessageUseMapper;
import com.nt.framework.model.SmsMessageUse;
import com.nt.framework.model.enumModel.MessageStatus;
import com.nt.framework.model.enumModel.MessageType;
import com.nt.framework.service.SmsMessageUseService;
import com.nt.framework.util.CommonUtils;

/**
 * 
 * @ClassName: SmsMessageUseServiceImpl
 * @Description: 短信使用情况
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月10日 下午7:50:55
 */
@Transactional(readOnly = true)
@Service
public class SmsMessageUseServiceImpl extends BaseServiceImpl<SmsMessageUse> implements SmsMessageUseService {

	@Autowired
	private SmsMessageUseMapper smsMessageUseMapper;

	@Autowired
	protected void setMapper(SmsMessageUseMapper mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 
	 * @Title: saveAfterSmsMessage
	 * @Description: 在smsMessage保存之后调用
	 * @param verifyCodeKey
	 * @param businessKey
	 * @param phone
	 * @param content
	 * @return
	 * @see com.nt.framework.service.SmsMessageUseService#saveAfterSmsMessage(java.lang.String,
	 *      java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean saveAfterSmsMessage(String verifyCodeKey, String businessKey, String phone, String content) {
		SmsMessageUse smu = new SmsMessageUse();
		smu.setSmsNumber(phone);
		smu.setSmsContent(content);
		smu.setSendTime(new Date());
		String sn = CommonUtils.buildSmsMessageSn();
		smu.setSn(sn);
		smu.setStatus(MessageStatus.SUCCESS);
		smu.setType(MessageType.CHECKING);
		smu.setVerifyCode(verifyCodeKey);
		smu.setBusinessKey(businessKey);
		smu.setUsed(false);// 未被使用过
		save(smu);
		return true;
	}
}
