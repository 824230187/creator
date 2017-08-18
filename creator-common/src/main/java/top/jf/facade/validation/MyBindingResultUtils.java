/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/14
 * @time 17:11
 */
public class MyBindingResultUtils {
	
	public static BindingResult checkAndReturn(BindingResult bindingResult){
		if(bindingResult.hasErrors ()){
			for (FieldError error:bindingResult.getFieldErrors ()){
				throw new IllegalArgumentException (error.getDefaultMessage ());
			}
		}
		return bindingResult;
	}
}
