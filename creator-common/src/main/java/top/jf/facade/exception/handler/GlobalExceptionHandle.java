/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.exception.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jf.facade.base.result.SimpleResult;
import top.jf.facade.enums.CommonCode;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/14
 * @time 11:31
 */
//Controller类的辅助类，最常用的就是处理全局异常的切面类
@ControllerAdvice(basePackages = {"top.jf.controller"})
public class GlobalExceptionHandle {
	
	private final Logger logger = LoggerFactory.getLogger (GlobalExceptionHandle.class);
	
	private SimpleResult setup(Exception e){
		logger.info ("------本次请求抛出了一个{}异常，请求结束------\n",e.getClass ());
		SimpleResult result = new SimpleResult ();
		//有异常就直接判失败
		result.setToFail ();
		result.setMessage (e.getMessage ());
		result.setDescription (e.getMessage ());
		return result;
	}
	
	/**
	 * 全局异常处理器
	 * @ExceptionHandler -->处理指定异常类
	 */
	//处理非法参数异常
	@ExceptionHandler(IllegalArgumentException.class)
	//必须要定义responseBody,不然会报一个错误java.lang.AssertionError: Content type not set
	@ResponseBody
	public SimpleResult illegalArgumentExceptionHandler(IllegalArgumentException e){
		//如果进入这个方法，说明我们指定的包下的某个类抛出了一个异常，故在这里进行一系列处理
		SimpleResult result = setup (e);
		result.setToFail (CommonCode.ILLEGAL_ARGUMENT_EXCEPTION);
		return result;
	}
	
	//处理运行时异常
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public SimpleResult runtimeExceptionHandler(RuntimeException e){
		SimpleResult result = setup (e);
		result.setToFail (CommonCode.BIZ_EXCEPRION);
		return result;
	}
	
	//处理空指针异常
	@ExceptionHandler(NullPointerException.class)
	@ResponseBody
	public SimpleResult nullPointerExceptionHandler(NullPointerException e){
		SimpleResult result = setup (e);
		result.setToFail (CommonCode.NULL_ARGUMENT_EXCEPTION);
		return result;
	}
}
