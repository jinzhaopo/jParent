package com.nt.framework.annotation.validation;

import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: RegexFieldValidate
 * @Description: 正则表达式的验证
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月22日 上午10:07:08
 */
public class RegexFieldValidate implements IValidate {

	public WebErrors validate(HttpServletRequest request, WebErrors errors, Validations validations, Map<String, String> decodedUriVariables) {
		RegexFieldValidator[] rfvs = validations.regexFields();
		for (RegexFieldValidator rfv : rfvs) {
			String fieldName = rfv.fieldName();
			String regex = rfv.expression();
			String value = request.getParameter(fieldName);
			if (StringUtils.isEmpty(value) && decodedUriVariables != null) {
				value = decodedUriVariables.get(fieldName);
			}
			if (StringUtils.isEmpty(value) || !Pattern.matches(regex, value)) {
				errors.addErrorCode(rfv.message());
			}
		}
		return errors;
	}

	@Override
	public String getName() {
		return "正则表达式的验证";
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
