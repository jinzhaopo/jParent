package com.nt.framework.config.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 
 * @ClassName: HttpMessageConvertersConfig
 * @Description: mvc--json解析配置
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年8月31日 上午11:17:47
 */
@Configuration
public class HttpMessageConvertersConfig {
	/**
	 * 
	 * @Title: fastJsonHttpMessageConverters
	 * @Description: 注入HttpMessageConverters<br>
	 *               重新解析mvc返回的json
	 * @return
	 * @return: HttpMessageConverters
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.valueOf(MediaType.TEXT_XML_VALUE + ";charset=UTF-8"));
		fastConverter.setSupportedMediaTypes(supportedMediaTypes);

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

}
