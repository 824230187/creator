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
 * @time 15:22
 */
public class Student implements Person{
	
	@Override
	public String getName () {
		return "JF";
	}
	
	@Override
	public Integer getAge () {
		return 20;
	}
	
	@Override
	public void sing () {
		System.out.println ("哈哈哈哈嗝");
	}
	
	@SuppressWarnings ("deprecation")
	public static void main (String[] args) {
		Person p = new Student ();
		//编译器会警告我们，这个方法已经过时，若要忽略警告，需要在方法前加入相应注解
		p.sing ();
		
	}
}
