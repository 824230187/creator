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
 * @date 2017/10/30
 * @time 9:34
 */


class A { A(){
	System.out.println ("A()");
} }

class B extends A { B(){ System.out.println("B()");} }

class C extends A {
	B b = new B(); // will then construct another A and then a B
	public static void main(String[] args) {
		C c = new C(); // will construct an A first
	}
}

