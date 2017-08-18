/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.order;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;


/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/12
 * @time 9:13
 */
@Data
public class UserTestOrder {
	
	/**
	 * 接收前端传入的参数
	 * */
	@NotNull(message = "ID不能为空")
	private Integer id;
	
	@Max (value = 15,message = "用户名最大不能超过15位")
	private String username;
	
	@Length(min = 5, max = 20, message = "密码长度为5-20个字符")
	private String password;
	
	private Integer sex;
	
}
