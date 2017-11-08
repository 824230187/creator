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
 * @time 15:23
 */
class Cycle {
	
	/***
	 * 利用基类作为参数，继而利用子类调用成员方法，实现向上转型
	 */
	protected void ride(Cycle c){
		System.out.println ("ride,ride..." + c);
		System.out.println ("wheels:"+wheels ());
	}
	
	protected int wheels(){
		return 4;
	}
	
	public static void main (String[] args) {
		Bicycle b = new Bicycle ();
		Unicycle u = new Unicycle ();
		Tricycle t = new Tricycle ();
		//此时,Cycle的子类Bicycle向上转型为Cycle，并调用了方法ride()，后两个同理;
		b.ride (b);
		u.ride (u);
		t.ride (t);
	}
}

class Unicycle extends Cycle{
	protected int wheels(){
		return 1;
	}
}

class Bicycle extends Cycle {
	protected int wheels(){
		return 4;
	}
}

class Tricycle extends Cycle{
	protected int wheels(){
		return 3;
	}
}


