package com.nt.framework.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.framework.annotation.validation.IValidate;
import com.nt.framework.annotation.validation.ValidationBundle;
import com.nt.framework.annotation.validation.Validations;
import com.nt.framework.servlet.WebErrors;
import com.nt.framework.util.FastJsonUtils;
import com.nt.framework.util.ResponseUtils;
import com.nt.framework.util.SpringUtils;

/**
 * 
 * @ClassName: ValidationInterceptor
 * @Description: 验证拦截器
 * @author: jinzhaopo
 * @date: 2015-5-11 上午11:16:52
 */
public class ValidationInterceptor implements HandlerInterceptor {

	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		WebErrors errors = WebErrors.create();
		Map<String, String> decodedUriVariables = null;
		HandlerMethod hm = (HandlerMethod) handler;
		Validations validations = hm.getMethodAnnotation(Validations.class);
		if (validations == null) {
			return true;
		}
		Object obj = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		if (obj != null) {
			decodedUriVariables = (Map<String, String>) obj;
		}

		ValidationBundle validationBundle = (ValidationBundle) SpringUtils.getBean("validationBundle");
		List<IValidate> iValidates = validationBundle.getiValidates();
		for (IValidate validate : iValidates) {
			errors = validate.validate(request, errors, validations, decodedUriVariables);
		}
		if (errors.hasErrors()) {
			String xRequestedWith = request.getHeader("X-Requested-With");
			if (xRequestedWith != null && xRequestedWith.equalsIgnoreCase("XMLHttpRequest")) {
				ResponseUtils.ajaxJsonErrorMessage(FastJsonUtils.toJSONString(errors.getErrors()), response);
			} else {
				// request.setAttribute(Constant.WEBERRORS, errors);
				// 跳转到错误页面 目前是没有
				ResponseUtils.ajaxJsonErrorMessage(FastJsonUtils.toJSONString(errors.getErrors()), response);
				// request.getRequestDispatcher(Constant.WEBERRORS_URL_REQUEST).forward(request,
				// response);
			}
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
