/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.controller.demo;

import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import top.jf.demo.order.UserTestOrder;
import top.jf.demo.result.UserTestResult;
import top.jf.facade.base.result.SimpleResult;
import top.jf.facade.exception.BusinessException;
import top.jf.facade.validation.MyBindingResultUtils;
import top.jf.http.eneity.UserOrderRequest;
import top.jf.service.demo.DemoService;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/12
 * @time 11:19
 */
@RestController
//@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/queryUser")
//	@ResponseBody
	public UserTestResult queryUserById(@RequestParam("id") Integer id, @RequestParam("username") String username){
		UserTestResult result = demoService.selectById (id, username);
		return result;
	}
	
	@RequestMapping("/queryAll")
	public UserTestResult queryAll(){
		return demoService.queryAll ();
	}
	
	@RequestMapping("/updateUser")
	public SimpleResult updateUser(@RequestParam("params") String params){
//		MyBindingResultUtils.checkAndReturn (bindingResult);
		Gson gson = new Gson ();
		UserOrderRequest userOrderRequest = gson.fromJson (params, UserOrderRequest.class);
		UserTestOrder order = new UserTestOrder ();
		BeanUtils.copyProperties (userOrderRequest, order);
		return demoService.updateUser (order);
	}
	
	@RequestMapping("/test/exception")
	public SimpleResult testException(){
		throw new BusinessException ("自定义业务层异常");
	}
	
	@RequestMapping("/test/json")
	public SimpleResult testJson(@RequestParam("params") String params){
		SimpleResult result = new SimpleResult ();
		result.setToSuccess (params);
		return result;
	}
	
	@GetMapping("/test/str")
	public String testStr(){
		return "str";
	}
}
