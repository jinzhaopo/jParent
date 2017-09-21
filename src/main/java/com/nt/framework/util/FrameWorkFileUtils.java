package com.nt.framework.util;

import org.apache.commons.io.FileUtils;

/**
 * 
 * @ClassName: FrameWorkFileUtils
 * @Description: 用来创建需要的文件 mapper.xml *mapper service serviceImpl
 * @author: jinzhaopo
 * @version: V1.0
 * @date: 2017年9月15日 下午3:33:20
 */
public class FrameWorkFileUtils {
	private String prefixPackage = "";
	private String className = "";
	private String prefixFilePath = "";

	public FrameWorkFileUtils(String prefixPackage, String className, String prefixFilePath) {
		this.prefixPackage = prefixPackage;
		this.className = className;
		this.prefixFilePath = prefixFilePath; 
	}

	/**
	 * 
	 * @Title: getMapperXml
	 * @Description: 获取mapper的xml文件
	 * @param className
	 *            注意类名称要大写
	 * @return: void
	 */
	public void getMapperXml(String className, String namespace) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("\r");// 回车
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
		sb.append("\r");
		sb.append("<mapper namespace=\"" + namespace + "\" >");
		sb.append("</mapper>");

		FileHelpers.write("C:\\Users\\Administrator\\Desktop\\" + className + "Mapper.xml", sb.toString());

	}

	/**
	 * 
	 * @Title: getMapper
	 * @Description: 获取mapper.java的文件 但是要导入类
	 * @param className
	 * @param packageName
	 * @return: void
	 */
	public void getMapper(String className, String packageName) {
		StringBuilder sb = new StringBuilder();
		sb.append("package " + packageName + ";");
		sb.append("\r");
		sb.append("public interface " + className + "Mapper extends MyMapper<" + className + "> {}");

		FileHelpers.write("C:\\Users\\Administrator\\Desktop\\" + className + "Mapper.java", sb.toString());

	}
}
