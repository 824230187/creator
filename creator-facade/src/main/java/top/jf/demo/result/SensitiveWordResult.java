/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.result;

import lombok.Data;
import top.jf.demo.info.SensitiveWordInfo;
import top.jf.facade.base.result.SimpleResult;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/24
 * @time 11:22
 */
@Data
public class SensitiveWordResult extends SimpleResult {
	
	private List<String> datas;
	
	private List<SensitiveWordInfo> list;
	
	private Integer tatolCount;//总记录
	
}
