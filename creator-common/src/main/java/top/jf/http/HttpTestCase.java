/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.http;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import top.jf.http.eneity.UserOrderRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/7
 * @time 14:05
 */
public class HttpTestCase {
	
	/**
	 * 模拟Http请求
	 * */
	public static void main (String[] args) {
		HttpClientUtils httpClientUtils = new HttpClientUtils ();
		String response = null;
//		String url = "http://localhost:8888/demo/queryUser";
		String url = "http://localhost:8888/demo/updateUser";
		//无参情况下利用Get方法进行传输
		//response = httpClientUtils.doGet (url);
		
		Map<String, String> map = new HashMap<> ();
		map.put ("id", "2");
		map.put ("password","13123123131312323");
		
		Gson gson = new Gson ();
		String json = gson.toJson (map);
		Map<String, String> jsonMap = new HashMap<> ();
		jsonMap.put ("params", json);
		//map形式传输
		response = httpClientUtils.doPostMap (url, jsonMap);
		
		//json形式传输
//		Gson gson = new Gson ();
//		String params1 = gson.toJson (params);
//		response = httpClientUtils.doPostJson (url, params1);
		
		
		System.out.println (response);
	}
	
}
