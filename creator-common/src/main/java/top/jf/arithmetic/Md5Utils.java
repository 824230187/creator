/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.arithmetic;

import top.jf.entity.UserTest;

import java.security.MessageDigest;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/6
 * @time 11:24
 */
public class Md5Utils {
	
	/**
	 * MD5算法
	 *
	 * PS：MD5不是一种加密算法，而是一种报文摘要算法
	 * 加密算法是与解密并存的，是可逆的，可以通过某种介质得到原始数据。
	 * 而MD5算法是不可逆的，通过摘要得到的数据是不可逆的
	 * */
	
	/**
	 * 生成md5
	 * @param message 加密内容
	 * @return
	 */
	public static String getMD5(String message) {
		String md5str = "";
		try {
			//1 创建一个提供信息摘要算法的对象，初始化为md5算法对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//2 将消息变成byte数组
			byte[] input = message.getBytes();
			
			//3 计算后获得字节数组,这就是那128位了
			byte[] buff = md.digest(input);
			
			//4 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
			md5str = bytesToHex(buff);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5str;
	}
	
	/**
	 * 小写结果
	 * */
	public static String getMD5LowCase(String message){
		return getMD5 (message).toLowerCase ();
	}
	/**
	 * 二进制转十六进制
	 * @param bytes
	 * @return
	 */
	public static String bytesToHex(byte[] bytes) {
		StringBuffer md5str = new StringBuffer();
		//把数组每一字节换成16进制连成md5字符串
		int digital;
		for (int i = 0; i < bytes.length; i++) {
			digital = bytes[i];
			
			if(digital < 0) {
				digital += 256;
			}
			if(digital < 16){
				md5str.append("0");
			}
			md5str.append(Integer.toHexString(digital));
		}
		return md5str.toString().toUpperCase();
	}
	
	public static void main (String[] args) {
		UserTest userTest = new UserTest ();
		userTest.setPassword ("1234656");
		System.out.println (userTest);
		System.out.println (userTest.getPassword ());
		System.out.println (getMD5LowCase (userTest.getPassword ()));
		System.out.println ("a");
	}
}
