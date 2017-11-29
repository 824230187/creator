/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.service.demo;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.jf.demo.api.DemoApi;
import top.jf.demo.info.UserTestInfo;
import top.jf.demo.order.SimpleUserOrder;
import top.jf.demo.order.UserTestOrder;
import top.jf.demo.result.UserTestResult;
import top.jf.entity.UserTest;
import top.jf.entity.UserTestExample;
import top.jf.facade.base.result.SimpleResult;
import top.jf.facade.enums.CommonCode;
import top.jf.mapper.UserTestMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/10
 * @time 10:35
 */
@Component
public class DemoService implements DemoApi{
	
	@Autowired
	private UserTestMapper userTestMapper;
	
	
	private static final Logger logger = LoggerFactory.getLogger (DemoService.class);
	
	public UserTestResult queryAll(){
		List<UserTestInfo> userTestInfos = new ArrayList<> ();
		UserTestResult result = new UserTestResult ();
		List<UserTest> list = userTestMapper.selectByExample (new UserTestExample ());
		
		for(UserTest data:list){
			UserTestInfo info = new UserTestInfo ();
			BeanUtils.copyProperties (data,info);
			userTestInfos.add (info);
		}
		result.setInfoList (userTestInfos);
		result.setToSuccess ("查询集合成功");
		return result;
	}
	
	public UserTestResult selectById(Integer id, String username){
		UserTestInfo userTestInfo = new UserTestInfo ();
		UserTestResult result = new UserTestResult ();
//		UserTest userTest = userTestMapper.selectByPrimaryKey (id);
		UserTestExample ex = new UserTestExample ();
		ex.or ().andIdEqualTo (id).andUsernameEqualTo (username);
		
		List<UserTest> userTests = userTestMapper.selectByExample (ex);
		if(!CollectionUtils.isEmpty (userTests)){
			BeanUtils.copyProperties (userTests.get (0), userTestInfo);
			result.setInfo (userTestInfo);
		}
		result.setToSuccess ("查询成功！");
		return result;
	}
	
	public SimpleResult updateUser(UserTestOrder order){
		SimpleResult result = new SimpleResult ();
		UserTest userTest = new UserTest ();
		BeanUtils.copyProperties (order, userTest);
		int flag = userTestMapper.updateByPrimaryKeySelective (userTest);
		
		//验证不通过，抛出异常，并由全局异常处理器统一处理异常
		Preconditions.checkArgument (flag==1,"更新数据失败！请检查sql语句");
		result.setToSuccess ("更新成功！");
		return result;
	}
	
	public UserTestResult queryByPage(Integer sex, Integer pageNum, Integer pageSize){
		UserTestResult result = new UserTestResult ();
		UserTestExample ex = new UserTestExample ();
		ex.or ().andSexEqualTo (sex);
		
		PageHelper.startPage (pageNum,pageSize);
		List<UserTestInfo> userTestInfos = new ArrayList<> ();
		List<UserTest> list = userTestMapper.selectByExample (ex);
		Page<UserTest> page = (Page<UserTest>) list;
		
		if(!CollectionUtils.isEmpty (list)){
			for(UserTest data : list){
				UserTestInfo info = new UserTestInfo ();
				BeanUtils.copyProperties (data, info);
				userTestInfos.add (info);
			}
		}
		result.setInfoList (userTestInfos);
		result.setCount (page.getTotal ());
		result.setToSuccess ("查询成功!");
		return result;
	}
	
	
	/*public SimpleResult insertNewData (SimpleUserOrder order) {
		SimpleResult result = new SimpleResult ();
		UserTest userTest = new UserTest ();
		BeanUtils.copyProperties (order, userTest);
		
		//自定义序列名生成全局唯一ID
		userTest.setId (Integer.parseInt (extraMapper.newId ("my_seq","001")));
		try {
			userTestMapper.insert (userTest);
		} catch (Exception e) {
			logger.error ("插入数据失败");
			result.setToFail (CommonCode.BIZ_EXCEPRION, "插入数据失败");
			return result;
		}
		
		result.setToSuccess ("新增用户成功！");
		return result;
	}*/
}
