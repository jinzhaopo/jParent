package com.nt.framework.service.impl;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.framework.mapper.SmsMessageMapper;
import com.nt.framework.model.SmsMessage;
import com.nt.framework.model.enumModel.MessageStatus;
import com.nt.framework.model.enumModel.MessageType;
import com.nt.framework.service.SmsMessageService;
import com.nt.framework.util.CommonUtils;
import com.nt.framework.util.FreeMarkerPaser;
import com.nt.framework.util.SettingUtils;

/**
 * 
 * @ClassName: SmsMessageServiceImpl
 * @Description: 短信发送service实现类
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年4月22日 下午1:19:19
 */
@Service
public class SmsMessageServiceImpl extends BaseServiceImpl<SmsMessage> implements SmsMessageService {

	@Autowired
	private SmsMessageMapper smsMessageMapper;

	@Autowired
	public void setMapper(SmsMessageMapper mapper) {
		super.setMapper(mapper);
	}

	/**
	 * 
	 * @Title: sendSimpleMessage
	 * @Description: 发送单条短信
	 * @param phoneNum
	 * @param content
	 * @param sendTime
	 * @param type
	 * @return
	 * @throws IOException
	 * @see com.yundao.tour.service.SmsMessageService#sendSimpleMessage(java.lang.String,
	 *      java.lang.String, java.util.Date,
	 *      com.yundao.tour.model.SmsMessage.MessageType)
	 */
	public Boolean sendSimpleMessage(String phoneNum, String content, Date sendTime, MessageType type) throws IOException {
		String sn = CommonUtils.buildSmsMessageSn();
		SmsMessage message = new SmsMessage();
		message.setSn(sn);// 设置
		message.setType(type);
		message.setSmsNumber(phoneNum);
		if (sendTime == null) {
			message.setSendTime(new Date());
		} else {
			message.setSendTime(sendTime);
		}
		message.setSmsContent(content);
		// message = get("sn", sn);

		// 调用方法
		String MSG = "";
		try {
			Class clz = Class.forName(SettingUtils.getSetting().getSmsClassName());
			Object obj = clz.newInstance();
			// 获取方法
			Method m = obj.getClass().getDeclaredMethod(SettingUtils.getSetting().getSmsMethodName(), String.class);
			MSG = (String) m.invoke(obj, phoneNum, content);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		MSG = MSG.substring(MSG.indexOf("<returnstatus>") + 14, MSG.indexOf("</returnstatus>"));
		// 短信发送成功
		if ("Success".equals(MSG)) {
			message.setStatus(MessageStatus.SUCCESS);// 发送失败
			save(message);
			return true;
		} else {
			message.setStatus(MessageStatus.FIALURE);// 发送成功
			save(message);
			return false;
		}
		// 发送短信 返回成功的时候修改状态
		//
		// String username = SettingUtils.get().getSmsUserName();
		// String password_md5 =
		// DigestUtils.md5Hex(SettingUtils.get().getSmsPassword());
		// String apikey = SettingUtils.get().getSmsApikey();
		//
		// String result = SendSMSUtil.doSendMessage(username, password_md5,
		// phoneNum, apikey, content);
		// if (result.startsWith("success")) {
		// // 成功
		// message.setStatus(MessageStatus.SUCCESS);
		// sendStatus = true;
		// } else {
		// // 失败
		// message.setStatus(MessageStatus.FIALURE);
		// sendStatus = false;
		// }
		// message.setDescription(result);
		// update(message);
		// return sendStatus;
	}

	/**
	 * 
	 * @Title: sendMessageTemplateName
	 * @Description: 根据模版发送短信接口
	 * @param phoneNum
	 * @param template_name
	 * @param map
	 * @param sendTime
	 * @param type
	 * @return
	 * @throws IOException
	 * @see com.yundao.tour.service.SmsMessageService#sendMessageTemplateName(java.lang.String,
	 *      java.lang.String, java.util.Map, java.util.Date,
	 *      com.yundao.tour.model.SmsMessage.MessageType)
	 */
	public Boolean sendMessageTemplateName(String phoneNum, String template_name, Map<String, String> map, Date sendTime, MessageType type) throws IOException {
		if (StringUtils.isEmpty(phoneNum)) {
			return false;
		}
		String regExp = "^[1][0-9]{10}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phoneNum);
		if (!m.matches()) {
			return false;
		}
		FreeMarkerPaser.set(new FreeMarkerPaser());
		FreeMarkerPaser freeMarkerPaser = FreeMarkerPaser.getInstance();
		freeMarkerPaser.setPageFolder(SettingUtils.getSetting().getFreemarkerTemplatePath());
		freeMarkerPaser.setPageName(template_name);
		freeMarkerPaser.putData(map);
		String content = freeMarkerPaser.proessPageContent();
		return this.sendSimpleMessage(phoneNum, content, null, type);
	}
}
