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
 * @time 9:44
 */
class f{
	float price;
}

public class test1 {
	/**
	 * Think in java 课后习题
	 * 第二章：
	 *   练习2:
	 *   创建一个包含一个float域的类，并用这个类来展示别名机制
	 * */
	public static void main (String[] args) {
		/*f f1 = new f();
		f f2 = new f();
		f1.price = 20.5f;
		f2.price = 21.5f;
		
		System.out.println ("f1.price:" + f1.price + "    f2.price:" + f2.price);
		
		f1 = f2;
		
		System.out.println ("f1.price:" + f1.price + "    f2.price:" + f2.price);
		
		f2.price = 7210.5f;
		
		System.out.println ("f1.price:" + f1.price + "    f2.price:" + f2.price);*/
	
		/**
		 * 第一个结果是false的原因是，new出两个新的Integer对象，在堆内存中分配了两个新的地址，这i1,i2分别指向这两个不同的地址
		 * 而关系运算符==比较的是两个地址，所以结果是false
		 * */
		Integer i1 = new Integer (3);
		Integer i2 = new Integer (3);
		System.out.println (i1 == i2);
		
		/**
		 * 第二个结果是true的原因是。系统将基本类型的值存放于栈内存中，会先去对比常量缓存池中维护的值，Integer的范围是-128到127，
		 * 如果在此范围中，那么i5,i6的值会指向缓存池中的常量3，所以i5,i6利用==比较都是常量3的内存地址，结果为true
		 * */
		Integer i5 = 3;
		Integer i6 = 3;
		System.out.println (i5 == i6);
		
		/**
		 * 第三个结果是false原因是，这两个数值都不是Integer常量缓存池的范围-128到127之间，故在声明i3时，会到栈内存中新new出
		 * 一个新的Integer对象(new Integer(1254124151))，同样i4也一样新new出Integer对象，故他们的内存地址是不同的，结果false
		 * */
		Integer i3 = 1254124151;
		Integer i4 = 1254124151;
		System.out.println (i3 == i4);
		
		
	}
	
	
	
	
	
}
