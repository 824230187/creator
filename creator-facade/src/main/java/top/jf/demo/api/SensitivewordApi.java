/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.api;

import top.jf.demo.result.SensitiveWordResult;
import top.jf.entity.KeyWord;
import top.jf.facade.base.result.SimpleResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/24
 * @time 10:38
 */
public interface SensitivewordApi {
	
	/**
	 * 替换敏感字
	 * @param sourceText 源文本
	 * @param replaceText 替换文本(***)
	 * */
	String replaceSensitiveWord(String sourceText, String replaceText);
	
	
	/**
	 * 找到所有敏感词
	 * */
	SensitiveWordResult findAll();
	
	
	/**
	 * 批量插入敏感词
	 * */
	SimpleResult batchInsert(String text);
	
	
	/**
	 * 批量删除敏感词
	 * */
	SimpleResult batchDelete(String text);
	
}
