/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.exercises.chapter2;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/10/25
 * @time 15:10
 */
public class test5 {
	/**
	 * Think in java 课后习题
	 * 第四章：
	 *   练习8:
	 *   写一个switch开关，为每一个case打印一个消息。然后把这个switch放进for循环来测试每一个case。先让每个case后面都有break，测试一下
	 *   然后再把每个break删掉看会出现什么情况
	 * */
	
	public static void main (String[] args) {
		for(int i=0; i<3; i++){
			switch (i){
				case 0:
					System.out.println ("inner0");
//					break;
				case 1:
					System.out.println ("inner1");
//					break;
				case 2:
					System.out.println ("inner2");
//					break;
			}
			
		}
		
	}
	
}
