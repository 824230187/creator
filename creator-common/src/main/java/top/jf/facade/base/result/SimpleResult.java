/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.base.result;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import top.jf.facade.enums.CommonCode;
import top.jf.facade.enums.Status;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/11
 * @time 13:39
 */
public class SimpleResult {
	
	/**
	 * 设置统一返回结果
	 * */
	//状态
	@NotNull(message = "状态不能为空")
	private Status status;
	
	//信息码
	@NotNull(message = "信息码不能为空")
	private String code;
	
	//信息
	private String message;
	
	//详细描述
//	@Size(min = 2, max = 200, message = "详细描述长度在{min}-{max}内")
	private String description;
	
	/**
	 * 设置成功结果
	 * */
	//无参的情况
	public void setToSuccess(){
		setStatus (Status.SUCCESS);
		setCode (CommonCode.EXECUTE_SUCCESS.getCode ());
		setMessage (CommonCode.EXECUTE_SUCCESS.getMessage ());
	}
	//传入详情描述的情况
	public void setToSuccess(String description){
		setToSuccess ();
		setDescription (description);
	}
	
	/**
	 * 设置失败结果
	 * */
	public void setToFail(){
		setStatus (Status.FAIL);
		//无参情况下默认为“未知异常”
		setCode (CommonCode.UNKNOWN_EXCEPRION.getCode ());
		setMessage (CommonCode.UNKNOWN_EXCEPRION.getMessage ());
	}
	//传入参数重载code和message
	public void setToFail(CommonCode commonCode){
		setToFail ();
		setCode (commonCode.getCode ());
		setMessage (commonCode.getMessage ());
	}
	public void setToFail(CommonCode commonCode, String description){
		setToFail (commonCode);
		setDescription (description);
	}
	public void setToFail(String description){
		setToFail ();
		setMessage (description);
		setDescription (description);
	}
	
	
	public SimpleResult () {
	}
	
	public SimpleResult (Status status) {
		this.status = status;
	}
	public SimpleResult (Status status, String code) {
		this.status = status;
		this.code = code;
	}
	
	public SimpleResult (Status status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
	
	public SimpleResult (Status status, String code, String message, String description) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.description = description;
	}
	
	public Status getStatus () {
		return status;
	}
	
	public void setStatus (Status status) {
		this.status = status;
	}
	
	public String getCode () {
		return code;
	}
	
	public void setCode (String code) {
		this.code = code;
	}
	
	public String getMessage () {
		return message;
	}
	
	public void setMessage (String message) {
		this.message = message;
	}
	
	public String getDescription () {
		if(StringUtils.isEmpty (description)){
			return getMessage ();
		}
		return description;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	@Override
	public String toString () {
		return "\n结果集---------->"+ToStringBuilder.reflectionToString (this, ToStringStyle.JSON_STYLE);
	}
}
