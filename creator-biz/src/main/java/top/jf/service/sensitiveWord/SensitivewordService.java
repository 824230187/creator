/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.service.sensitiveWord;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.jf.demo.api.SensitivewordApi;
import top.jf.demo.info.SensitiveWordInfo;
import top.jf.demo.result.SensitiveWordResult;
import top.jf.entity.KeyWord;
import top.jf.entity.KeyWordExample;
import top.jf.facade.base.result.SimpleResult;
import top.jf.mapper.KeyWordMapper;
import top.jf.sensitiveWord.SensitivewordFilter;

import java.util.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/24
 * @time 10:44
 */
@Component
public class SensitivewordService implements SensitivewordApi {
	
	@Autowired
	private KeyWordMapper keyWordMapper;
	
	@Override
	public String replaceSensitiveWord (String sourceText, String replaceText) {
		List<String> dbWords = keyWordMapper.findAllWords ();
		//调用敏感词过滤工具替换文本
		String targetText = SensitivewordFilter.replaceSensitiveWord (dbWords, sourceText, replaceText);
		return targetText;
	}
	
	@Override
	public SensitiveWordResult findAll () {
		SensitiveWordResult result = new SensitiveWordResult ();
		KeyWordExample ex = new KeyWordExample ();
		List<KeyWord> keyWords = keyWordMapper.selectByExample (ex);
		List<SensitiveWordInfo> list  = new ArrayList<> ();
		for (KeyWord data : keyWords) {
			SensitiveWordInfo info = new SensitiveWordInfo ();
			BeanUtils.copyProperties (data, info);
			list.add (info);
		}
		result.setList (list);
		result.setToSuccess ("查询敏感词列表成功！");
		return result;
	}
	
	@Override
	public SimpleResult batchInsert (String text) {
		SimpleResult result = new SimpleResult ();
		String[] sensitiveWords = text.split (",");
		//去重
		Set<String> words = new HashSet<> (Arrays.asList (sensitiveWords));
		
		
		for (String word : words) {
			KeyWordExample ex = new KeyWordExample ();
			ex.or ().andKeyWordEqualTo (word);
			List<KeyWord> keyWords = keyWordMapper.selectByExample (ex);
			//判断当前传入敏感词是否存在，存在的话就不添加了
			if (CollectionUtils.isNotEmpty (keyWords)) {
				continue;
			}
			KeyWord newWord = new KeyWord ();
			newWord.setKeyWord (word);
			newWord.setCreateTime (new Date ());
			keyWordMapper.insert (newWord);
		}
		
		List<String> list = keyWordMapper.findAllWords ();
		//初始化词库
		SensitivewordFilter.filterInit (list);
		
		result.setToSuccess ("添加敏感词成功！");
		return result;
	}
	
	@Override
	public SimpleResult batchDelete (String text) {
		SimpleResult result = new SimpleResult ();
		String[] sensitiveWords = text.split (",");
		int total = sensitiveWords.length;
		int successCount = 0;
		for (String sensitiveWord : sensitiveWords) {
			int flag = keyWordMapper.delSensitiveWord (sensitiveWord);
			if(flag == 1){
				successCount++;
			}
		}
		
		List<String> list = keyWordMapper.findAllWords ();
		//初始化词库
		SensitivewordFilter.filterInit (list);
		
		result.setToSuccess ("执行成功！请求删除"+ total +"个敏感词;删除成功"+successCount+"个敏感词;"+
				                     "删除失败(当前词库中不存在)"+(total-successCount)+"个敏感词");
		return result;
	}
}
