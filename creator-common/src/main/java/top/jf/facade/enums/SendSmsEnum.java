/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.enums;

import org.apache.commons.lang.RandomStringUtils;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/13
 * @time 11:39
 */
public enum SendSmsEnum {
	/**
	 * 描述
	 */
	//NAME ("code", "message"),
	TEST_MESSAGE("这是一条来自于JF的测试短信。服务热线：15923076029",5),
	VERIFICATION_CODE("您的手机验证码为:#code,请及时输入!",5),
	;
	
	/**
	 * 短信内容
	 */
	private String content;
	
	/**
	 * 同类型短信每日最大可发短信数
	 */
	private final Integer maxCount;
	
	private String code;
	/**
	 * 构造一个<code>SendSmsEnum</code>枚举对象
	 *
	 * @param content
	 * @param maxCount
	 */
	private SendSmsEnum (String content, Integer maxCount) {
		this.content = content;
		this.maxCount = maxCount;
	}
	
	public String getContent () {
		this.code = RandomStringUtils.randomNumeric (6);
		this.content = content.replace ("#code", code);
		return content;
	}
	
	public Integer getMaxCount () {
		return maxCount;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String getCode () {
		return code;
	}
}
