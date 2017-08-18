/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.info;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import top.jf.facade.base.info.AbstractInfo;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/11
 * @time 15:17
 */
@Data
public class UserTestInfo extends AbstractInfo {
	
	private String username;
	
	private String password;
	
	/**
	 * 1.男 2.女
	 * */
	private Integer sex;
	
	
}
