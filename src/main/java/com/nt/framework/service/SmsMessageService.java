package com.nt.framework.service;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.nt.framework.model.SmsMessage;
import com.nt.framework.model.enumModel.MessageType;

/**
 * 
 * @ClassName: SmsMessageService
 * @Description: 短信
 * @author: zhaopo
 * @date: 2016年11月28日 下午3:33:41
 */
public interface SmsMessageService extends BaseService<SmsMessage> {
	/**
	 * 发送短信接口
	 * 
	 * @param phoneNum
	 *            短信号码
	 * @param content
	 *            短信内容
	 * @param content
	 *            短信内容
	 * @return 返回发送状态
	 * @throws IOException
	 */
	public Boolean sendSimpleMessage(String phoneNum, String content, Date sendTime, MessageType type) throws IOException;

	/**
	 * 
	 * @Title: sendMessageTemplateName
	 * @Description: 规矩模板发送短信
	 * @param phoneNum
	 * @param template_name
	 * @param map
	 * @param sendTime
	 * @param type
	 * @return
	 * @throws IOException
	 * @return: Boolean
	 */
	Boolean sendMessageTemplateName(String phoneNum, String template_name, Map<String, String> map, Date sendTime, MessageType type) throws IOException;

}
