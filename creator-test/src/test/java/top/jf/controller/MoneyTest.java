/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.controller;

import org.apache.commons.lang3.StringUtils;

import javax.accessibility.AccessibleHyperlink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/8/10
 * @time 15:44
 */
public class MoneyTest {
	
	private static String moneyFormat(String num){
		String [] limit = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
//		String [] unit = {"分","角","拾","百","千","萬","億"};
		String [] unit = {"拾","百","千","萬","拾萬","百萬","千萬","億","拾億","百億","千億","萬億","億億"};
		int length = num.split ("\\.")[0].length ();
		
		StringBuilder sb = new StringBuilder ();
		for (int i=0;i<limit.length;i++) {
			num = num.replace (String.valueOf (i),limit[i]);
		}
		
		for (int i=0;i<num.length ();i++) {
			sb.append (num.substring (i,i+1));
		}
		int dotIndex = sb.indexOf (".");
		System.out.println ("sbLength:"+sb.length ());
		for (int i=2;i<=length;i++) {
			if (length>=i) {
				if (dotIndex != -1) {
					System.out.println ("dotIndex:"+dotIndex);
					sb.insert(dotIndex-(i-1),unit[i-2]);
				} else {
					String substring = sb.substring (i-1, i);
					if (!StringUtils.equals (substring, limit[0])) {
						sb.insert ((length-(i-1)),unit[i-2]);
					}
				}
			}
		}
		
		System.out.println ("Method:"+sb.toString ());
		
		return num;
	}
	
	
	public static void main (String[] args) {
		/*String money = moneyFormat ("70005");
		System.out.println (money);*/
		List<String> list = new ArrayList<> ();
		list.add ("1");
		list.add ("2");
		
		Iterator<String> iterator = list.iterator ();
		while (iterator.hasNext ()){
			String str = iterator.next ();
			if("1".equals (str)){
				iterator.remove ();
			}
		}
		System.out.println (list.toString ());
		
		
	}
}
