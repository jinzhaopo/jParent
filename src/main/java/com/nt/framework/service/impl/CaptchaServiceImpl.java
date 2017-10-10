package com.nt.framework.service.impl;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import com.nt.framework.constants.Constant;
import com.nt.framework.service.MyCaptchaService;
import com.octo.captcha.service.CaptchaService;

/**
 * 
 * @ClassName: CaptchaServiceImpl
 * @Description: 验证码
 * @author: zhaopo
 * @date: 2016年11月4日 上午11:03:55
 */
@Service
public class CaptchaServiceImpl implements MyCaptchaService {

	@Resource
	private CaptchaService imageCaptchaService;

	/**
	 * 
	 * @Title: buildImage
	 * @Description: 创建验证码图片
	 * @param captchaId
	 * @return
	 * @see com.gaiya.ceo.service.MyCaptchaService#buildImage(java.lang.String)
	 */
	public BufferedImage buildImage(String captchaId) {
		return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
	}

	/**
	 * 
	 * @Title: isValid
	 * @Description: 验证验证码
	 * @param captchaId
	 * @param captcha
	 * @return
	 * @see com.gaiya.ceo.service.MyCaptchaService#isValid(java.lang.String,
	 *      java.lang.String)
	 */
	public boolean isValid(String captchaId, String captcha) {
		if (!StringUtils.isNotEmpty(captchaId) || !StringUtils.isNotEmpty(captcha)) {
			return false;
		}
		try {
			return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase()).booleanValue();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * @Title: createVerifyCodeKey
	 * @Description: 创建验证码
	 * @param verifyCodeKey
	 * @return
	 * @see com.nt.framework.service.MyCaptchaService#createVerifyCodeKey(java.lang.String)
	 */
	@Override
	public String createVerifyCodeKey(String verifyCodeKey) {
		StringBuffer verifyCodeKeySB = new StringBuffer();
		verifyCodeKeySB.append(System.currentTimeMillis());
		verifyCodeKeySB.append(Constant.VERIFY_CODE_KEY_SEPARATOR);
		verifyCodeKeySB.append(verifyCodeKey);

		return verifyCodeKeySB.toString();
	}

	/**
	 * 
	 * @Title: isTimeOutOfVerifyCodeKey
	 * @Description: 校验验证码是否超时<br>
	 *               StringUtils.substringAfter(oldCode,
	 *               Constant.VERIFY_CODE_KEY_SEPARATOR).equals(code) 判断验证码是否错误
	 * @param oldCode
	 * @return
	 * @see com.nt.framework.service.MyCaptchaService#isTimeOutOfVerifyCodeKey(java.lang.String)
	 */
	@Override
	public Boolean isTimeOutOfVerifyCodeKey(String oldCode) {
		if (StringUtils.isNotBlank(oldCode)) {
			long time = Long.valueOf(StringUtils.substringBefore(oldCode, Constant.VERIFY_CODE_KEY_SEPARATOR));
			Date verifyCodeBuildDate = new Date(time);
			Date verifyCodeExpiredDate = DateUtils.addMinutes(verifyCodeBuildDate, Constant.DYNAMIC_PASSWORD_PERIOD);
			Date now = new Date();
			if (now.after(verifyCodeExpiredDate)) {
				return true;
			}
		}
		return false;
	}
}
