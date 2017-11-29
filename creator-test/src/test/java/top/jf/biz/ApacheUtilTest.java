/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.biz;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.jf.core.CreatorApplication;
import top.jf.entity.UserTest;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/29
 * @time 11:53
 */
@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CreatorApplication.class)
public class ApacheUtilTest {
	
	@Test
	public void test1(){
		
	}
	
	public static void main (String[] args) {
		//CollectionUtils并集
		List<UserTest> list = new ArrayList<> ();
		list.add (new UserTest ());
		list.add (new UserTest ());
		list.add (new UserTest ());
		
		Set<UserTest> set = new HashSet<> ();
		set.add (new UserTest ());
		set.add (new UserTest ());
		
		List<UserTest> union = (List<UserTest>)CollectionUtils.union (list, set);
		System.out.println (union);
		
		//CollectionUtils交集
		List<String> list2 = new ArrayList<> ();
		List<String> list3 = new ArrayList<> ();
		list2.add ("1");
		list2.add ("2");
		list2.add ("3");
		list3.add ("1");
		
		Collection intersection = CollectionUtils.intersection (list2, list3);
		System.out.println (intersection);
		
		
		System.out.println (CollectionUtils.disjunction (list2,list3));
		//差集
		System.out.println (CollectionUtils.subtract (list2,list3));
		
		System.out.println (CollectionUtils.containsAny (list2, list3));
		
		System.out.println (CollectionUtils.getCardinalityMap (set));
		
		System.out.println (CollectionUtils.isSubCollection (list2,list3));
		
		System.out.println (CollectionUtils.isEqualCollection (list,set));
		
	}
}
