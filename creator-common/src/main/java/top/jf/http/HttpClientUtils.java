/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.http;

import okhttp3.*;
import org.apache.coyote.http2.ConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.jf.facade.exception.BusinessException;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/7
 * @time 11:36
 */
public class HttpClientUtils {
	
	private final OkHttpClient okHttpClient = new OkHttpClient ().newBuilder ().connectTimeout (5, TimeUnit.MINUTES)
			.readTimeout (8, TimeUnit.MINUTES).build ();
	
	private static final Logger logger = LoggerFactory.getLogger (HttpClientUtils.class);
	/**
	 * 发送http请求工具类，及获取返回参数
	 * */
	/**
	 * Get请求
	 * @param url 请求地址
	 * */
	public String doGet(String url){
	
		//创建request对象
		//new Request.Builder ().head("","").xxxx.url (url).build () request添加头信息
		Request request = new Request.Builder ().url (url).build ();
		String responseBody = getResponseBody (request, url);
		return responseBody;
	}
	
	
	/**
	 * Post请求,Json形式传入参数
	 * */
	public String doPostJson(String url, String json){
		MediaType type = MediaType.parse ("application/json;charset=utf-8");
		//以Json形式发送请求
		RequestBody requestBody = RequestBody.create (type, json);
		
		String responseBody = doPost (url, requestBody);
		return responseBody;
	}
	
	
	public String doPostMap(String url, Map<String, String> map){
		FormBody.Builder builder = new FormBody.Builder ();
		for (Map.Entry<String, String> data : map.entrySet ()) {
			builder.add (data.getKey (), data.getValue ());
		}
		
		RequestBody requestBody = builder.build ();
		String responseBody = doPost (url, requestBody);
		return responseBody;
	}
	
	
	private String doPost(String url, RequestBody body){
		//post请求，手动添加参数请求
		//RequestBody requestBody = new FormBody.Builder ().add ("","").add ("","").build ();
		//创建request请求对象
		Request request = new Request.Builder ().url (url).post (body).build ();
		String responseBody = getResponseBody (request, url);
		return responseBody;
	}
	
	private String getResponseBody(Request request, String url){
		String responseBody = null;
		try {
			Response response = okHttpClient.newCall (request).execute ();
			responseBody = response.body ().string ();
			logger.info ("response响应信息：{}" ,responseBody);
		}  catch (IOException e) {
			throw new BusinessException ("请求"+url+"失败");
		}  catch (Exception e){
			throw new RuntimeException ("连接超时");
		}
		return responseBody;
	}
	
}
