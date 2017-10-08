package com.nt.framework.annotation.validation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.nt.framework.servlet.WebErrors;

/**
 * 
 * @ClassName: IntRangeValidate
 * @Description: int验证
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年10月6日 下午2:10:39
 */
public class IntRangeValidate implements IValidate {

	@Override
	public WebErrors validate(HttpServletRequest request, WebErrors errors, Validations validations, Map<String, String> decodedUriVariables) {
		String regex = "\\d*";
		IntRangeFieldValidator[] irfvs = validations.intRangeFields();
		for (IntRangeFieldValidator irfv : irfvs) {
			String fieldName = irfv.fieldName();
			String value = request.getParameter(fieldName);
			if (StringUtils.isEmpty(value) && decodedUriVariables != null) {
				value = decodedUriVariables.get(fieldName);
			}
			if (StringUtils.isEmpty(value) || !Pattern.matches(regex, value)) {
				errors.addErrorString(irfv.message());
				continue;
			}
			BigDecimal number = new BigDecimal(value);
			String minStr = irfv.min();
			if (!StringUtils.isBlank(minStr)) {
				if (Pattern.matches(regex, minStr)) {
					BigDecimal min = new BigDecimal(minStr);
					if (min.compareTo(number) > 0) {
						errors.addErrorString(irfv.message());
						continue;
					}
				} else {
					errors.addErrorString(irfv.message());
					continue;
				}
			}
			String maxStr = irfv.max();
			if (!StringUtils.isBlank(maxStr)) {
				if (Pattern.matches(regex, maxStr)) {
					BigDecimal max = new BigDecimal(maxStr);
					if (max.compareTo(number) < 0) {
						errors.addErrorString(irfv.message());
						continue;
					}
				} else {
					errors.addErrorString(irfv.message());
					continue;
				}
			}
		}
		return errors;
	}

	@Override
	public String getName() {
		return "int类型验证";
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
