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
 * @time 10:33
 */
public class test3 {
	
	/**
	 * Think in java 课后习题
	 * 第二章：
	 *   练习8:
	 *   展示用十六进制和八进制计数法来操作long值
	 * */
	public static void main (String[] args) {
		long hex = 0x2333;//十六进制0x前缀
		long oct = 02333;//八进制0前缀
		//转二进制
		System.out.println ("hex二进制:" +  Long.toBinaryString (hex) +"    oct二进制：" + Long.toBinaryString (oct));
		
		/**
		 * float double指数计数法所能表示的最大最小值
		 * */
		double max = java.lang.Double.MAX_VALUE;
		System.out.println("Max double = " + max);
		double min = java.lang.Double.MIN_VALUE;
		System.out.println("Min double = " + min);
		float maxf = java.lang.Float.MAX_VALUE;
		System.out.println("Max float = " + maxf);
		float minf = java.lang.Float.MIN_VALUE;
		System.out.println("Min float = " + minf);
		
	}
	
}
