/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.jf.BaseTest;
import top.jf.ControllerTestUtils;
import top.jf.core.CreatorApplication;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/12
 * @time 16:01
 */
@RunWith (SpringRunner.class)
@SpringBootTest(classes = CreatorApplication.class)
public class DemoControllerTest extends BaseTest{
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	private ControllerTestUtils controllerTestUtils = new ControllerTestUtils ();
	
	
	//初始化mockMvc对象
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup (this.wac).build ();//模拟springmvc对象
	}
	
	/**
	 * 无参控制器测试
	 * */
	@Test
	public void test() throws Exception{
//		System.out.println (controllerTestUtils.getResponseContentWithOutParam (mockMvc,"/demo/test/exception"));
		System.out.println (controllerTestUtils.getResponseContentWithOutParam (mockMvc,"/demo/queryAll"));
	}
	
	/**
	 * param注解测试
	 * */
	@Test
	public void test2() throws Exception{
		Map<String, String> m1 = new HashMap<> ();
		m1.put ("sex","1");
		m1.put ("pageNum","1");
		m1.put ("pageSize","10");
		System.out.println (controllerTestUtils.getParamOfResponseContent (mockMvc, m1, "/demo/queryByPage"));
		
	}
	
	/**
	 * requestBody注解测试
	 * */
	@Test
	public void test3() throws Exception{
		Map<String, Object> m2 = new HashMap<> ();
		m2.put ("id",3);
//		m2.put("username","qewqelll1231111111111111111111111111111111111111111111111111");
		m2.put ("password","qewqell1111111111111111111111111111111111111111111");
		System.out.println (controllerTestUtils.getBodyOfResponseContent (mockMvc, m2, "/demo/updateUser"));
	}
	
	public static void main (String[] args) {
		/*String str = "1";
		String[] split = str.split (",");
		List<String> list = new ArrayList<> ();
		for(String s:split){
			list.add (s);
		}
		System.out.println (list);*/
		/*String str="topic1:3,topic2:4,topic3:5,topic4:6,topic5:5,topic6:4,topic7:5";
		List<String> list = new ArrayList<> ();
		List<String> topicIdList = new ArrayList<> ();
		List<String> numList = new ArrayList<> ();
		for(String s:str.split (",")){
			list.add (s);
		}
		
		for(int i=0;i<list.size ();i++){
			String[] split = list.get (i).split (":");
			topicIdList.add (split[0]);
			numList.add (split[1]);
		}
		System.out.println ("topicId："+topicIdList+"       numList:"+numList);*/
		
		/*String str = "1";
		for(int i=0;i<10;i++){
			str+="2";
		}
		StringBuilder sb = new StringBuilder ();
		sb.append (str);
		for(int i=0;i<10;i++){
			sb.append ("3");
		}
		System.out.println (str);
		System.out.println (str.length ());
		System.out.println (sb.toString ().length ());*/
		
		/*Map<Object,String> map = new HashMap<> ();
		map.put (1,"123");
		Assert.notEmpty (map,"xxx");
		Preconditions.checkNotNull (map,"xxx");*/
		//方式1， 拿到keySet ，再利用foreach取得value集合
		Map<String, String> map = new HashMap<> ();
		map.put ("car1", "BWM");
		map.put ("car2", "QQ");
		/*Set<String> keySet = map.keySet ();
		
		for (String string : keySet) {
			System.out.println ("key:"+string+"     value:"+map.get (string));
		}*/
		
		//方式2： 直接通过entrySet的方式拿到对象
	/*	for (Map.Entry<String, String> data : map.entrySet ()) {
			System.out.println ("key:"+data.getKey ()+"       value:"+data.getValue ());
		}*/
		
		//方式3：jdk8 map新特性  forEach方法
		List<String> list = new ArrayList<> ();
		list.add ("123");
		list.forEach ((final String name) -> System.out.println (name));
		
		map.forEach ((String key, String value) -> System.out.println ("key:"+key+"   value:"+value));
		
		list.forEach (System.out::println);
		
	}
}
