/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.exercises.chapter2;

import java.util.Random;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/10/25
 * @time 9:50
 */
public class test2 {
	/**
	 * Think in java 课后习题
	 * 第二章：
	 *   练习7:
	 *   模拟扔硬币的结果
	 * */
	public static void main (String[] args) {
		Random random = new Random ();
		int i = random.nextInt (10);
		int j = random.nextInt (10);
		if (i>j) {
			System.out.println ("正");
		} else {
			System.out.println ("反");
		}
	}
	
	
	
}
