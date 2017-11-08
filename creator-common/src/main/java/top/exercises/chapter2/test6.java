/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.exercises.chapter2;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/10/25
 * @time 15:34
 */
public class test6 {
	/**
	 * Think in java 课后习题
	 * 第四章：
	 *   练习9:
	 *   一个斐波那契数列由数字1,1,2,3,5,8,13,21,34等等组成，其中每一个数字(从第三个数字开始)都是前两个数字的合。
	 *   创建一个方法，接收一个整数参数，并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。
	 *   例如：如果运行java Fibonacci 5 ,那么就输出1,1,2,3,5
	 * */
	
	
	private static Integer fibonacci(Integer num){
		if(num<2){
			return 1;
		}else{
			return (fibonacci (num-2)+fibonacci (num-1));
		}
	}
	
	private static void printF(Integer num){
		for(int i=0; i<num; i++){
			if(i == num-1){
				System.out.print (fibonacci (i));
			} else{
				System.out.print (fibonacci (i)+",");
			}
		}
		
	}
	
	public static void main (String[] args) {
//		printF (5);
		
		/*for(int i=1;i<=9;i++){
			System.out.println ();
			for(int j=1;j<=i;j++){
				System.out.print (j+"*"+i+"="+i*j+"\t");
			}
		}*/
	
		
	}
	
	
	
	
}
