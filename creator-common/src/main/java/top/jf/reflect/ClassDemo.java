/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.reflect;

import java.applet.Applet;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/8/11
 * @time 9:51
 */
public class ClassDemo {
	
	/**
	 * JAVA反射
	 *    学习记录
	 * */
	public static void main (String[] args) {
		/**
		 *万物皆对象，类也是对象，是Class类的实例对象
		  
		 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
		 **/
		Foo foo = new Foo ();
		
		//第一种方式   这种方式实际上是告诉了我们每一个类都隐含了一个静态的成员变量class, 前提是我们已经知道该类的类名
		Class c1 = Foo.class;
		
		//第二种方式   通过调用getClass方法，前提是我们已经拥有该类的实例对象
		Class c2 = foo.getClass ();
		
		//第三种方式   知道这个类的全名，根据forName方法来获取到这个类的实例
		try {
			Class c3 = Class.forName ("top.jf.reflect.Foo");
			System.out.println (c1 == c2);
			System.out.println (c2 == c3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace ();
			System.out.println ("ClassNotFoundException异常，没有找到指定类！");
		}
		
		//官网说，以上的c1,c2也表示了Foo类的类类型，我们可以通过类类型来得到这个对象的实例
		//调用此方法返回的是一个Object对象，我们需要对其进行强转
		try {
			Foo instance = (Foo) c1.newInstance ();
			instance.sayHello ();
			
			//利用反射的形式来调用方法,绕过编译
			System.out.println ("=================绕过编译，利用反射调用方法======================");
			try {
				Method m = c1.getDeclaredMethod ("sayHello");
				m.invoke (instance);
			} catch (NoSuchMethodException e) {
				e.printStackTrace ();
			} catch (InvocationTargetException e) {
				e.printStackTrace ();
			}
			System.out.println ("=================获取类的成员方法======================");
			/**
		 * 获取类的成员方法
		 * */
//			printMethodMessage (String.class);
			printMethodMessage (instance);
		} catch (InstantiationException e) {
			e.printStackTrace ();
		} catch (IllegalAccessException e) {
			e.printStackTrace ();
		}
		
		/**
		 * 在编译时加载类为静态加载类， 在运行时加载的类为动态加载类
		 *
		 * 例如：当我们维护一个程序时，我们更新版本的时候，需要遵循运行时加载的法则。这样对于用户而言会更友好。
		 * 类似与QQ，当QQ里新增加了功能，如果遵循“动态加载”的法则，效果是立竿见影的。因为对于程序员而言，程序不用重新编译
		 * 再打包，程序员只需实现一套规范，关注新增的功能即可。而对于用户而言，他们不需要重新下载软件，重新登录一次（重新运行）
		 * 即可看到软件新增的功能。
		 * */
		
		
		/**
		 * 成员变量也是对象
		 * 被封装在java.lang.Reflect.field
		 * field类中封装了关于成员变量的操作
		 * */
		System.out.println ("=================反射得到类的成员属性======================");
		//以下方法获取了这个实例对象的public成员变量的信息
//		Field[] fields = c1.getFields ();
		//以下方法获取了这个实例对象的所有成员信息，不分权限
		Field[] fields = c1.getDeclaredFields ();
		for(Field field : fields){
			System.out.println ("成员属性类型："+field.getType ()+"     成员属性名"+field.getName ());
		}
		
		System.out.println ("=================反射得到类的构造方法======================");
		//以下方法会得到类的public权限的构造方法
//		Constructor[] constructors = c1.getConstructors ();
		//以下方法会得到类的所有构造方法，不分权限
		Constructor[] constructors = c1.getDeclaredConstructors ();
		
		for(Constructor constructor : constructors){
			System.out.print (constructor.getName ()+"(");
			Class[] parameterTypes = constructor.getParameterTypes ();
			for(Class c : parameterTypes){
				System.out.print (c.getName ()+",");
			}
			System.out.println (")");
		}
		
	}
	
	private static void printMethodMessage(Object obj){
		Class<?> aClass = obj.getClass ();
		//这个方法会获取实例类当中的public成员方法，包括起继承类的Public方法
//		Method[] methods = aClass.getMethods ();
		 
		//这个方法会获取实例类当中所有的方法，不分权限。但不包括继承类的方法
		Method[] methods = aClass.getDeclaredMethods ();
		for(Method method : methods){
			System.out.println (method);
		}
		
	}
	
	
}


class Foo extends Applet{
	
	private String name;
	public String remark;
	
	public Foo () {
	}
	
	private Foo (String name) {
		this.name = name;
	}
	
	public Foo (String name, String remark) {
		this.name = name;
		this.remark = remark;
	}
	
	void sayHello(){
		System.out.println ("hello");
	}
}
