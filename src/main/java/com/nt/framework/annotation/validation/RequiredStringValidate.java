package com.nt.framework.annotation.validation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: RequiredStringValidate
 * @Description: 字符串非空校验
 * @author: jinzhaopo
 * @date: 2015-5-11 下午12:37:05
 */
public class RequiredStringValidate implements IValidate {

	public WebErrors validate(HttpServletRequest request, WebErrors errors, Validations validations, Map<String, String> decodedUriVariables) {
		RequiredStringValidator[] rsvs = validations.requiredStrings();
		for (RequiredStringValidator rsv : rsvs) {
			String fieldName = rsv.fieldName();
			String value = request.getParameter(fieldName);
			if (StringUtils.isEmpty(value) && decodedUriVariables != null) {
				value = decodedUriVariables.get(fieldName);
			}
			if (!rsv.trim() && StringUtils.isEmpty(value) || rsv.trim() && StringUtils.isBlank(value)) {
				errors.addErrorCode(rsv.message());
			}
		}
		return errors;
	}

	@Override
	public String getName() {
		return "字符串非空校验";
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
