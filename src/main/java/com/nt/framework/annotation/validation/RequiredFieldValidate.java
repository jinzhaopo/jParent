package com.nt.framework.annotation.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: RequiredFieldValidate
 * @Description: 对象非空验证器
 * @author: jinzhaopo
 * @date: 2015年5月10日 下午11:10:14
 */
public class RequiredFieldValidate implements IValidate {

	public WebErrors validate(HttpServletRequest request, WebErrors errors, Validations validations, Map<String, String> decodedUriVariables) {
		RequiredFieldValidator[] rFiled = validations.requiredFields();
		for (RequiredFieldValidator rfv : rFiled) {
			String fieldName = rfv.fieldName();
			String value = request.getParameter(fieldName);
			if (StringUtils.isEmpty(value) && decodedUriVariables != null) {
				value = decodedUriVariables.get(fieldName);
			}
			if (value == null) {
				errors.addErrorCode(rfv.message());
			}
		}
		return errors;
	}

	@Override
	public String getName() {
		return "对象非空验证器";
	}

	@Override
	public String getVersion() {
		return "V1.0";
	}

	@Override
	public String getAuthor() {
		return "jinzhaopo";
	}

}
