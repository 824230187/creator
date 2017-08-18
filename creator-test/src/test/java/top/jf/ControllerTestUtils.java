/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf;

import net.minidev.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/12
 * @time 17:02
 */
public class ControllerTestUtils {
	
	//返回response结果字符串(适用于responseBody注解)，传入一个对象的时候
	public String getBodyOfResponseContent(MockMvc mockMvc, Map<String, Object> map, String url) throws Exception{
		MvcResult mvcResult = getBodyOfMvcResult (mockMvc, map, url);
		return mvcResult.getResponse ().getContentAsString ();
	}
	
	//传入非参数，以xxParam的形式
	public String getParamOfResponseContent(MockMvc mockMvc, Map<String, String> map, String url) throws Exception{
		MvcResult mvcResult = getParamOfMvcResult (mockMvc, map, url);
		return mvcResult.getResponse ().getContentAsString ();
	}
	//无参形式
	public String getResponseContentWithOutParam(MockMvc mockMvc, String url) throws Exception{
		MvcResult mvcResult = getMvcResultWithoutParam (mockMvc, url);
		return mvcResult.getResponse ().getContentAsString ();
	}
	
	private MvcResult getBodyOfMvcResult(MockMvc mockMvc, Map<String, Object> map, String url) throws  Exception{
		ResultActions resultActions = mockMvc.perform (MockMvcRequestBuilders.post (url)
				                                         .contentType (MediaType.APPLICATION_JSON_UTF8)
				                                         .content (JSONObject.toJSONString (map)));
		MvcResult result = getMvcResult (resultActions);
		return result;
	}
	
	
	/**
	 * ----------实现方法--------------
	 * */
	private MvcResult getParamOfMvcResult(MockMvc mockMvc, Map<String, String> map, String url) throws  Exception{
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post (url)
				.contentType (MediaType.APPLICATION_JSON_UTF8);
		//我们将测试时传入的param参数添加到map中。判断传入map是否为空，不为空就调用MockHttpServletRequestBuilder的param方法添加参数
		if(!CollectionUtils.isEmpty (map)){
			//遍历map集合
			for(Map.Entry<String, String> entry : map.entrySet ()){
				mockHttpServletRequestBuilder.param (entry.getKey (),entry.getValue ());
			}
		}
		
		MvcResult result = getMvcResult (mockMvc.perform (mockHttpServletRequestBuilder));
		return result;
	}
	
	//无参形式
	private MvcResult getMvcResultWithoutParam(MockMvc mockMvc, String url) throws  Exception{
		ResultActions resultActions = mockMvc.perform (MockMvcRequestBuilders.post (url).contentType (MediaType.APPLICATION_JSON_UTF8));
		MvcResult result = getMvcResult (resultActions);
		return result;
	}
	
	//返回公共MvcResult
	private MvcResult getMvcResult(ResultActions resultActions)throws Exception{
		MvcResult result = resultActions.andExpect (MockMvcResultMatchers.status ().isOk ())//模拟发送post请求
				.andExpect (MockMvcResultMatchers.content ().contentType (MediaType.APPLICATION_JSON_UTF8))//预期返回utf-8编码
				.andReturn ();
		return result;
	}
}
