/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.service.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.jf.demo.order.SendSmsOrder;
import top.jf.facade.base.result.SimpleResult;
import top.jf.http.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/13
 * @time 10:39
 */
@Component
public class MwSendSmsService {
	
	/**
	 * 梦网短信平台相关接口调用
	 * */
	@Value ("${mw_sms_ip}")
	private String mwIp;
	
	@Value ("${mw_sms_port}")
	private String mwPort;
	
	@Value ("${mw_sms_userid}")
	private String mwUserid;
	
	@Value ("${mw_sms_pwd}")
	private String mwPwd;
	
	private static final Logger logger = LoggerFactory.getLogger (MwSendSmsService.class);
	
	public String sendSms(SendSmsOrder order){
		SimpleResult result = new SimpleResult ();
		
		logger.info ("请求短信平台接口：{};端口：{};账户:{};{}", mwIp, mwPort, mwUserid, mwPwd);
		Map<String, String> paramsMap = new HashMap<> ();
		paramsMap.put ("userId", mwUserid);
		paramsMap.put ("password", mwPwd);
		//目标号码，用英文逗号(,)分隔，最大1000个号码。
		//一次提交的号码类型不受限制，但手机会做验证，若有不合法的手机号将会被退回。
		//号码段类型分为：移动、联通、电信手机 注意：请不要使用中文的逗号
		paramsMap.put ("pszMobis", order.getPhoneNum ());
		//短信内容， 内容长度不大于350个汉字
		paramsMap.put ("pszMsg", order.getSendSmsEnum ().getContent ());
		
		System.out.println ("code:"+order.getSendSmsEnum ().getCode ());
		//号码个数（最大1000个手机）
		paramsMap.put ("iMobiCount", String.valueOf (order.getPhoneNum ().split (",").length));
		//子端口号码，不带请填星号{*} 长度由账号类型定4-6位，通道号总长度不能超过20位。
		paramsMap.put ("pszSubPort", "*");
		//用户自定义流水号，不带请输入0（流水号范围-（2^63）……2^63-1）
		paramsMap.put ("MsgId", "0");
//		paramsMap.put ("iReqType", null);
//		paramsMap.put ("Sa", null);
//		paramsMap.put ("multixmt", null);
		
		String postUrl = "http://"+mwIp+":"+mwPort+"/MWGate/wmgw.asmx/"+"MongateSendSubmit";
		
		HttpClientUtils httpClient = new HttpClientUtils ();
		String backResult = httpClient.doPostMap (postUrl, paramsMap);
		
		result.setMessage (backResult);
		
		return backResult;
	}
		
	
	
}
