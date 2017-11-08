/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.result;

import lombok.Data;
import top.jf.demo.info.UserTestInfo;
import top.jf.entity.UserTest;
import top.jf.facade.base.result.BizResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/11
 * @time 15:16
 */
@Data
public class UserTestResult extends BizResult<UserTestInfo>{
	
	private List<UserTestInfo> infoList;
	
	private Long count;
	
}
