/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.biz;

import org.apache.commons.codec.digest.DigestUtils;
import top.jf.arithmetic.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/29
 * @time 11:26
 */
public class DigestUtilTest {
	
	public static void main (String[] args) throws UnsupportedEncodingException {
		String str = "111111";
		// md5:消息摘要算法第五(Message Digest Algorithm)
		String md5Cipher = DigestUtils.md5Hex (str);
		// md5:消息摘要算法第二(Message Digest Algorithm)
		String md2Cipher = DigestUtils.md2Hex (str);
		//安全哈希算法(Secure Hash Algorithm)
		String sha1Cipher = DigestUtils.sha1Hex (str);
		String sha256Cipher = DigestUtils.sha256Hex (str);
		String sha384Cipher = DigestUtils.sha384Hex (str);
		String sha512Cipher = DigestUtils.sha512Hex (str);
		
		System.out.println ("md5:"+md5Cipher+"\n"+"md2:"+md2Cipher+"\n"+"sha1:"+sha1Cipher+"\n"
		+"sha256:"+sha256Cipher+"\n"+"sha384:"+sha384Cipher+"\n"+"sha512:"+sha512Cipher+"\n");
		
		//Base64
		String encode = Base64Utils.base64Encode (str);
		System.out.println ("Base64加密后:"+encode);
		String decode = Base64Utils.base64Decode (encode);
		System.out.println ("Base64解密后:"+decode);
	}
}
