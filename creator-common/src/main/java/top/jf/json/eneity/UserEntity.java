/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.json.eneity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/8/16
 * @time 9:53
 */
@Data
public class UserEntity {
    
    /**
     * 用于测试Gson将Json字符串反解析为对象的JavaBean
     * */
    private String username;
    
    private String password;
    
    private Integer sex;
    
    private Date birthday;
    
    private List<String> hobbyList;
    
    private String [] hobbyArr;
    
}
