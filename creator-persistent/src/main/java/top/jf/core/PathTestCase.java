/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.core;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.File;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/6
 * @time 14:08
 */
public class PathTestCase {
	
	public static void main (String[] args) throws Exception{
//		System.out.println (PathTestCase.class.);
		File file = new File ("");
		String absolutePath = file.getAbsolutePath ();
		String canonicalPath = file.getCanonicalPath ();
		
		System.out.println ("absolutePath:"+absolutePath);
		System.out.println ("canonicalPath"+canonicalPath);
		
		System.out.println (PathTestCase.class.getClassLoader ().getResource ("").getPath ());
	}
}
