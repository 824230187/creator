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
public class test7 {
	/**
	 * 第四章：
	 *   练习10:
	 *   吸血鬼数字是指位数为偶数的数字，可以由一对数字相乘而得到，而这对数字各包含乘积的一半位数的数字
	 *   其中从最初的数字中选取的数字可以任意排序。以两个0结尾的数字是不允许的，例如，下列数字都是“吸血鬼”数字
	 *
	 *   1260 = 21*60
	 *   1827 = 21*87
	 *   2187 = 27*81
	 *   写一个程序，找出4位数的所有吸血鬼数字(Dan Forhan推荐)
	 * */
	
	private static Integer[] disassembleNum(Integer num){
		/**
		 *  思路：
		 *  1、先将传入四位数拆分成为其数字包含的所有可能二位数 例如1260可得--->12,16,10;21,26,20;61,62,60;01,02,06
		 *  2、将结果集组装成一个整形数组返回
		 *  3、返回后将复制返回数组成2份，利用循环分别进行求积操作，若其中有积等于传入的四位数。那么这个数字就是吸血鬼数字
		 */
		String numStr = num.toString ();
		char[] chars = numStr.toCharArray ();
 		List<Integer> list = new ArrayList<> ();
		
		for(int i=0; i<chars.length; i++){
			for(int j=0;j<chars.length;j++){
				if(i!=j){
					String s = chars[i] + "" + chars[j];
					int disassembledNum = (Integer.valueOf (s)).intValue ();
					list.add (disassembledNum);
				}
			}
		}
		
		Integer[] disassembledArr = list.toArray (new Integer[12]);
		
		return disassembledArr;
	}


	public static void main (String[] args) {
		Map<Integer,String> vampireNumBox = new HashMap<> ();
		for(Integer num=1001;num<9999;num++){
			Integer[] arr = disassembleNum (num);
			for(int j=0; j<arr.length; j++){
				char[] numArr = num.toString ().toCharArray ();
				char[] innerArr = arr[j].toString ().toCharArray ();
				if(innerArr.length == 2){
					List<Integer> list = new ArrayList<> ();
					List<Integer> innerList = new ArrayList<> ();
					
					for(int x=0; x<numArr.length; x++){
						String s = numArr[x]+"";
						list.add (Integer.valueOf (s));
					}
					for(int x=0; x<innerArr.length; x++){
						String s = innerArr[x]+"";
						innerList.add (Integer.valueOf (s));
					}
					
					Set<Integer> set = new HashSet<> ();
					List<Integer> UnRepetitionList = new ArrayList<> ();
					for(int i=0;i<list.size ();i++){
						Integer value = list.get (i);
						if(set.contains (value)){
							UnRepetitionList.add (value);
						}else{
							set.add (value);
						}
					}
					
					list.removeAll (innerList);
					//类似于7880这种情况
					if(list.size ()==1){
						list.addAll (UnRepetitionList);
						//类似于1001这种情况
					} else if(list.size ()==0){
						list.addAll (innerList);
					}
				
					List<Integer> newList = new ArrayList<> ();
					for(Integer x=0; x<list.size (); x++){
						for(Integer y=0; y<list.size (); y++){
							if(list.get (x) != list.get (y)){
								String s = list.get (x) + "" + list.get (y);
								newList.add (Integer.valueOf (s));
							}
						}
					}
					
					for(int x=0;x<2;x++){
						if(newList.size ()!=0){
							int result = newList.get (x) * arr[j];
							//吸血鬼数字
							if(result == num){
								vampireNumBox.put (result, newList.get (x) + "*" + arr[j]);
							}
						}
					}
					
				}
			}
		}
		//遍历吸血鬼数字盒子
		System.out.println ("四位数吸血鬼数字：");
		for(Map.Entry<Integer, String> data : vampireNumBox.entrySet ()){
			System.out.print (data.getKey ()+"="+data.getValue ()+"\t");
		}
		
	}
	
	
	
}
