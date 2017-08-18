package top.jf.biz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.jf.BaseTest;
import top.jf.core.CreatorApplication;
import top.jf.demo.info.UserTestInfo;
import top.jf.demo.order.UserTestOrder;
import top.jf.entity.UserTest;
import top.jf.facade.base.result.SimpleResult;
import top.jf.service.demo.DemoService;



/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/7/10
 * @time 10:37
 */
@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CreatorApplication.class)
public class DemoTest extends BaseTest{

    @Autowired
    private DemoService demoService;

	private final Logger logger = LoggerFactory.getLogger (DemoTest.class);

    @Test
    public void test(){
    	System.out.println (demoService.queryAll ());
	    /*try {
		    System.out.println (demoService.selectById (1));
	    } catch (Exception e) {
		    SimpleResult result = new SimpleResult ();
		    result.setToFail (e.getMessage ());
		    System.out.println (result);
	    }*/
//	    UserTestOrder order = new UserTestOrder ();
//	    order.setId (1);
//	    order.setUsername ("aaaaaaa");
//	    order.setPassword ("root");
//	    System.out.println (demoService.updateUser (order));
    }
	
	public static void main (String[] args) {
		
	}

}