/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.facade.base.result;

import top.jf.facade.base.info.AbstractInfo;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/11
 * @time 14:31
 */
public class BizResult<T extends AbstractInfo> extends SimpleResult {

	private T info;
	
	public T getInfo () {
		return info;
	}
	
	public void setInfo (T info) {
		this.info = info;
	}
	
}
