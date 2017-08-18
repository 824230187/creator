/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.enums;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/11
 * @time 14:09
 */
public enum CommonCode {
	/**
	 * 执行成功
	 */
	EXECUTE_SUCCESS("200", "执行成功"),
	/**
	 * 处理中
	 */
	RUNNING_IN_PROCESS("comm_00_9999", "处理中"),
	
	/**
	 * 参数为空
	 */
	NULL_ARGUMENT_EXCEPTION("comm_10_0001", "参数为空"),
	
	/**
	 * 参数个数错误
	 */
	ILLEGAL_NUMBER_OF_ARGUMENT("comm_10_0101", "参数个数错误"),
	/**
	 * 参数类型错误
	 */
	ILLEGAL_ARGUMENT_TYPE("comm_10_0201", "参数类型错误"),
	
	/**
	 * 非法参数
	 */
	ILLEGAL_ARGUMENT_EXCEPTION("comm_10_0999", "非法参数"),
	
	/**
	 * 数据库异常
	 */
	DB_EXCEPRION("comm_10_1999", "数据库异常"),
	
	/**
	 * 业务异常
	 */
	BIZ_EXCEPRION("999", "业务异常"),
	
	/**
	 * 系统异常(系统的基础异常)
	 */
	SYS_EXCEPRION("999", "系统异常"),
	
	/**
	 * 系统异常(系统内部异常，比如工具类常，组件内部异常)
	 */
	NEST_EXCEPRION("999", "系统异常"),
	
	/**
	 * 网络异常
	 */
	NET_EXCEPRION("comm_90_9999", "网络异常"),
	
	/**
	 * 未知异常
	 */
	UNKNOWN_EXCEPRION("comm_99_9999", "未知异常"),;
	
	/**
	 * 枚举值
	 */
	private final String code;
	
	/**
	 * 枚举描述
	 */
	private final String message;
	
	/**
	 * 构造一个<code>CommonCode</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private CommonCode (String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode () {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage () {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code () {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message () {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 *
	 * @return CommonCode.java
	 */
	public static CommonCode getByCode (String code) {
		for (CommonCode _enum : values ()) {
			if (_enum.getCode ().equalsIgnoreCase (code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 *
	 * @return List<LocalCacheEnum>
	 */
	public java.util.List<CommonCode> getAllEnum () {
		java.util.List<CommonCode> list = new java.util.ArrayList<CommonCode> ();
		for (CommonCode _enum : values ()) {
			list.add (_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 *
	 * @return List<String>
	 */
	public java.util.List<String> getAllEnumCode () {
		java.util.List<String> list = new java.util.ArrayList<String> ();
		for (CommonCode _enum : values ()) {
			list.add (_enum.code ());
		}
		return list;
	}
	
	/**
	 * 判断给定的枚举，是否在列表中
	 *
	 * @param value  检查的值
	 * @param values 列表
	 *
	 * @return
	 */
	public boolean isInList (CommonCode value, CommonCode... values) {
		for (CommonCode e : values) {
			if (value == e) {
				return true;
			}
		}
		return false;
	}
}
