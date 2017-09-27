/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.order;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import top.jf.facade.base.order.AbstractOrder;
import top.jf.facade.enums.SendSmsEnum;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/9/13
 * @time 11:36
 */
public class SendSmsOrder extends AbstractOrder{
	
	//订单号
	@NotBlank
	private String orderNo;
	
	private String message;
	
	@Length(min = 11, max = 11)
	private String phoneNum;
	
	private SendSmsEnum sendSmsEnum;
	
	public String getOrderNo () {
		return orderNo;
	}
	
	public void setOrderNo (String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getMessage () {
		return message;
	}
	
	public void setMessage (String message) {
		this.message = message;
	}
	
	public String getPhoneNum () {
		return phoneNum;
	}
	
	public void setPhoneNum (String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public SendSmsEnum getSendSmsEnum () {
		return sendSmsEnum;
	}
	
	public void setSendSmsEnum (SendSmsEnum sendSmsEnum) {
		this.sendSmsEnum = sendSmsEnum;
	}
}
