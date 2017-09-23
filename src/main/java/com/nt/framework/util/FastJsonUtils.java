package com.nt.framework.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonUtils {

	private static final SerializeConfig config;

	static {
		config = new SerializeConfig();
		config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
		config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
	}

	private static final SerializerFeature[] features = { SerializerFeature.WriteMapNullValue, // 输出空置字段
			SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty // 字符类型字段如果为null，输出为""，而不是null
	};

	/**
	 * 
	 * @Title: toJSONString
	 * @Description: 获取json字符串
	 * @param object
	 *            目标对象
	 * @return
	 * @return: String
	 */
	public static String toJSONString(Object object) {
		return JSON.toJSONString(object, config, features);
	}

	/**
	 * 
	 * @Title: toJSONNoFeatures
	 * @Description: 获取json字符串
	 * @param object
	 *            对象
	 * @return
	 * @return: String
	 */
	public static String toJSONNoFeatures(Object object) {
		return JSON.toJSONString(object, config);
	}

	/**
	 * 
	 * @Title: toBean
	 * @Description: 根据json字符串获取对象
	 * @param text
	 *            json字符串
	 * @return
	 * @return: Object
	 */
	public static Object toBean(String text) {
		return JSON.parse(text);
	}

	/**
	 * 
	 * @Title: toBean
	 * @Description: 获取指定的对象
	 * @param text
	 *            json字符串
	 * @param clazz
	 *            对象的类型
	 * @return
	 * @return: T
	 */
	public static <T> T toBean(String text, Class<T> clazz) {
		return JSON.parseObject(text, clazz);
	}

	/**
	 * 
	 * @Title: toArray
	 * @Description: 转换为数组
	 * @param text
	 *            json字符串
	 * @return
	 * @return: Object[]
	 */
	public static <T> Object[] toArray(String text) {
		return toArray(text, null);
	}

	/**
	 * 
	 * @Title: toArray
	 * @Description: 转换成指定的数组
	 * @param text
	 *            json字符串
	 * @param clazz
	 *            类型
	 * @return
	 * @return: Object[]
	 */
	public static <T> Object[] toArray(String text, Class<T> clazz) {
		return JSON.parseArray(text, clazz).toArray();
	}

	/**
	 * 
	 * @Title: toList
	 * @Description: 转换成list
	 * @param text
	 *            json字符串
	 * @param clazz
	 *            类型
	 * @return
	 * @return: List<T>
	 */
	public static <T> List<T> toList(String text, Class<T> clazz) {
		return JSON.parseArray(text, clazz);
	}

	/**
	 * 将javabean转化为序列化的json字符串
	 * 
	 * @param keyvalue
	 * @return
	 */
	public static Object beanToJson(Object keyvalue) {
		String textJson = JSON.toJSONString(keyvalue);
		Object objectJson = JSON.parse(textJson);
		return objectJson;
	}
	
	/**
	 * 将string转化为序列化的json字符串
	 * 
	 * @param keyvalue
	 * @return
	 */
	public static Object textToJson(String text) {
		Object objectJson = JSON.parse(text);
		return objectJson;
	}

	/**
	 * 
	 * @Title: stringToCollect
	 * @Description: json字符串转化为map
	 * @param s
	 * @return
	 * @return: Map
	 */
	@SuppressWarnings("rawtypes")
	public static Map stringToCollect(String s) {
		Map m = JSONObject.parseObject(s);
		return m;
	}

	/**
	 * 
	 * @Title: collectToString
	 * @Description: 将map转化为string
	 * @param m
	 * @return
	 * @return: String
	 */
	@SuppressWarnings("rawtypes")
	public static String collectToString(Map m) {
		String s = JSONObject.toJSONString(m);
		return s;
	}

}