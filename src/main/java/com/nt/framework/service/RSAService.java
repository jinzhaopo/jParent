package com.nt.framework.service;

import java.security.interfaces.RSAPublicKey;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName: RSAService
 * @Description: 前端加密
 * @author: zhaopo
 * @date: 2016年11月4日 下午2:03:09
 */
public interface RSAService {

	/**
	 * 生成密钥(添加私钥至Session并返回公钥)
	 * 
	 * @param request
	 *            httpServletRequest
	 * @return 公钥
	 */
	RSAPublicKey generateKey(HttpServletRequest request);

	/**
	 * 移除私钥
	 * 
	 * @param request
	 *            httpServletRequest
	 */
	void removePrivateKey(HttpServletRequest request);

	/**
	 * 解密参数
	 * 
	 * @param name
	 *            参数名称
	 * @param request
	 *            httpServletRequest
	 * @return 解密内容
	 */
	String decryptParameter(String name, HttpServletRequest request);
}
