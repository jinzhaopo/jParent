package com.nt.framework.annotation.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: IValidate
 * @Description: 验证接口(所有验证器的公共方法：接口编程)
 * @author: Administrator
 * @date: 2015年5月10日 下午6:11:53
 */
public interface IValidate {

	/**
	 * 参数验证
	 * 
	 * @param request
	 * @param errors
	 * @param validations
	 * @return
	 */
	public WebErrors validate(HttpServletRequest request, WebErrors errors, Validations validations, Map<String, String> decodedUriVariables);

	/**
	 * 
	 * @Title: getName
	 * @Description: 插件名称
	 * @return
	 * @return: String
	 */
	public String getName();

	/**
	 * 
	 * @Title: getVersion
	 * @Description: 插件版本
	 * @return
	 * @return: String
	 */
	public String getVersion();

	/**
	 * 
	 * @Title: getAuthor
	 * @Description: 作者
	 * @return
	 * @return: String
	 */
	public String getAuthor();

}
