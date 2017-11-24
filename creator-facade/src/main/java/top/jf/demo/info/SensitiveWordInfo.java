/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.demo.info;

import lombok.Data;
import top.jf.facade.base.info.AbstractInfo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/11/24
 * @time 14:20
 */
@Data
public class SensitiveWordInfo extends AbstractInfo {
	private Long id;
	private String keyWord;
	private Date createTime;
}
