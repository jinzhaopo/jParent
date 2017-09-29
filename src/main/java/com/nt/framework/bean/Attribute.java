package com.nt.framework.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hsqldb.lib.HashMappedList;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * 
 * @ClassName: Attribute
 * @Description: 属性类 用来做key-value的 传输和存储作用
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月29日 上午9:55:43
 */
public class Attribute implements Serializable {
	private static final long serialVersionUID = 5585302905044487944L;

	private Attribute() {
	}

	/**
	 * 对象属性
	 */
	private Map<String, String> attribute = new HashMap<String, String>();

	/**
	 * 
	 * @Title: getAttribute
	 * @Description: 获取本身的对象
	 * @return
	 * @return: Attribute
	 */
	public static Attribute getAttribute() {
		return new Attribute();
	}

	/**
	 * 
	 * @Title: getAttribute
	 * @Description: 获取本身的对象
	 * @param keys
	 * @param values
	 * @return
	 * @return: Attribute
	 */
	public static Attribute getAttribute(String[] keys, String[] values) {
		Attribute attribute = new Attribute();
		for (int i = 0; i < keys.length; i++) {
			attribute.put(keys[i], values[i]);
		}
		return attribute;
	}

	/**
	 * 
	 * @Title: getAttribute
	 * @Description: 获取本身的对象
	 * @param json
	 * @return
	 * @return: Attribute
	 */
	public static Attribute getAttribute(String json) {
		Map<String, String> mapData = (Map<String, String>) JSONUtils.parse(json);
		Attribute attribute = getAttribute();
		for (Iterator<String> it = mapData.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			attribute.put(key, mapData.get(key));
		}
		return attribute;
	}

	/**
	 * 
	 * @Title: getJson
	 * @Description: 获取json对象
	 * @return
	 * @return: String
	 */
	public String getJson() {
		return JSONUtils.toJSONString(attribute);
	}

	/**
	 * 
	 * @Title: set
	 * @Description: 设值
	 * @param key
	 * @param value
	 * @return: void
	 */
	public void put(String key, String value) {
		attribute.put(key, value);
	}

	/**
	 * 
	 * @Title: get
	 * @Description: 取值
	 * @param key
	 * @param value
	 * @return
	 * @return: String
	 */
	public String get(String key) {
		return attribute.get(key);
	}

}
