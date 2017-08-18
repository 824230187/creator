/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.design;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/6
 * @time 13:49
 */
public class Singleton {
	/**
	 *  1.单例模式：饿汉模式
	 *   当jvm加载类的时候，就创建好了唯一实例。故在第一次加载类的时候速度较慢，但在调用实例的时候速度快。线程安全
	 * */
	//1.私有化构造方法。目的是为了不让外部这个实例对象
	private Singleton(){}
	
	//2.创建唯一实例，并用private static进行修饰，让这个实例变成类静态成员
	private static Singleton instance = new Singleton ();
	
	//3.实例公共获取方法，调用此方法返回唯一实例
	public Singleton getInstance(){
		return instance;
	}
	
	
	/**
	 *  2.单例模式：懒汉模式
	 *  当用户调用类的时候加载实例。故jvm加载类时的速度较快，但是加载类的速度较慢。线程不安全
	 * */
	/*private Singleton(){}
	
	private static Singleton instance;
	
	public static Singleton getInstance(){
		if(instance==null){
			instance = new Singleton ();
		}
		return instance;
	}
	*/
	
}
