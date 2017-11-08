/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.exercises.annotation;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/10/27
 * @time 15:21
 */
public interface Person {
	
	/**
	 * 注解相关练习
	 * */
	String getName();
	
	Integer getAge();
	
	//表示该方法已过时注解
	@Deprecated
	void sing();
	
	
}
