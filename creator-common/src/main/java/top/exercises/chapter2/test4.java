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
 * @time 14:24
 */
public class test4 {
	
	/**
	 * Think in java 课后习题
	 * 第四章：
	 *   练习2:
	 *   产生25个int类型的随机数。对于每一个随即值，使用if-else语句来将其分类为大于、小于或等于紧随它而随机生成的值
	 * */
	
	public static void main (String[] args) {
		Random random = new Random ();
		for (int i=0; i<25; i++){
			int randomNum1 = random.nextInt (10);
			int randomNum2 = random.nextInt (10);
			if(randomNum1 > randomNum2){
				System.out.println (randomNum1+"  "+randomNum2+"  随机数1 > 随机数2");
			}else if(randomNum1 < randomNum2){
				System.out.println (randomNum1+"  "+randomNum2+"  随机数1 < 随机数2");
			}else{
				System.out.println (randomNum1+"  "+randomNum2+"  随机数1 = 随机数2");
			}
			
		}
	}
}
