package com.nt.framework.service;

import com.nt.framework.model.SmsMessageUse;

/**
 * 
 * @ClassName: SmsMessageUseService
 * @Description: 短信使用---service
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月10日 下午7:48:46
 */
public interface SmsMessageUseService extends BaseService<SmsMessageUse> {
	/**
	 * 
	 * @Title: saveAfterSmsMessage
	 * @Description: 保存,在smsMessage之后调用的方法
	 * @param verifyCodeKey
	 * @return
	 * @return: boolean
	 */
	public boolean saveAfterSmsMessage(String verifyCodeKey, String businessKey,String phone,String content);

}
