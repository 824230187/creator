/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.arithmetic;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/29
 * @time 11:35
 */
public class Base64Utils {
	
	/**
	 * Base64编码
	 * */
	public static String base64Encode(String data){
		return Base64.encodeBase64String (data.getBytes ());
	}
	
	/**
	 * Base64解码
	 * */
	public static String base64Decode(String data) throws UnsupportedEncodingException {
		return new String (Base64.decodeBase64 (data.getBytes ()),"UTF-8");
	}
}
