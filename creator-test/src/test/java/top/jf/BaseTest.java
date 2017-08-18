/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf;

import org.junit.After;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/10
 * @time 15:34
 */
public abstract class BaseTest {
	
	private static SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
	
	private Date runDate;
	
	@Before
	public void startPrint(){
		runDate = new Date ();
		print("\n\n\n\n\n\n\n===================开始({})===================\n",dateFormat.format(runDate));
	}
	
	@After
	public void endPrint(){
		Date endDate = new Date();
		print("\n===================结束({})===================耗时:{}\n\n\n\n\n\n\n",dateFormat.format(endDate),formatTime(endDate.getTime()-runDate.getTime()));
		
	}
	
	protected void print(String format, Object... args) {
		System.out.println(formatWithThrow(format, args));
	}
	
	private static String formatWithThrow(String str, Object[] args) {
		if (str == null) {
			return null;
		} else {
			String string = str;
			int dIndex = str.indexOf("{}");
			if (dIndex == -1) {
				return str;
			} else {
				int beginIndex = 0;
				StringBuilder sb = new StringBuilder(100);
				byte index = 0;
				for (int i = index; i < args.length; ++i) {
					sb.append(string.substring(beginIndex, dIndex));
					sb.append(args[i]);
					beginIndex = dIndex + "{}".length();
					dIndex = string.indexOf("{}", beginIndex);
					if (dIndex == -1) {
						break;
					}
				}
				
				sb.append(string.substring(beginIndex));
				return sb.toString();
			}
		}
	}
	
	private static String formatTime(long timeMillis) {
		if (timeMillis < 1000) {
			return timeMillis + "ms";
		} else if (timeMillis < 60 * 1000) {
			return (timeMillis / 1000) + "." + (timeMillis % 1000) + "s";
		} else if (timeMillis < 60 * 60 * 1000) {
			long s = timeMillis / 1000;
			return (s / 60) + "m" + (s % 60) + "s" + (timeMillis % 1000) + "ms";
		} else {
			long s = timeMillis / 1000;
			long m = s / 60;
			
			return (m / 60) + "h" + (m % 60) + "m" + (s % 60) + "s" + (timeMillis % 1000) + "ms";
		}
	}
}
