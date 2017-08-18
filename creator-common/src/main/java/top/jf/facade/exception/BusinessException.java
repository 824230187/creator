/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.exception;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/14
 * @time 16:41
 */
public class BusinessException extends RuntimeException{
	
	/**
	 * 业务层统一抛出异常
	 * */
	private static final long serialVersionUID = 1399971186994404117L;
	
	private boolean ignore = false;
	
	public BusinessException() {
		super();
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(Throwable cause) {
		super(cause);
	}
	
	public boolean isIgnore() {
		return ignore;
	}
	
	public void setIgnore(boolean ignore) {
		this.ignore = ignore;
	}
	
}
