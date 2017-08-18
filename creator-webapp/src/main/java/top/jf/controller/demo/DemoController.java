/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.controller.demo;

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
	public SimpleResult updateUser(@RequestBody @Valid UserTestOrder order, BindingResult bindingResult){
		MyBindingResultUtils.checkAndReturn (bindingResult);
		return demoService.updateUser (order);
	}
	
	@RequestMapping("/test/exception")
	public SimpleResult testException(){
		throw new BusinessException ("自定义业务层异常");
	}
}
