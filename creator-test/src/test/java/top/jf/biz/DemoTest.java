package top.jf.biz;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.jf.BaseTest;
//import top.jf.core.CreatorApplication;
import top.jf.demo.order.SimpleUserOrder;
import top.jf.entity.UserTest;
import top.jf.facade.base.result.SimpleResult;
import top.jf.http.HttpClientUtils;
import top.jf.service.demo.DemoService;
import top.jf.service.sensitiveWord.SensitivewordService;
import top.jf.service.sms.MwSendSmsService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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
//@SpringBootTest(classes = CreatorApplication.class)
public class DemoTest extends BaseTest{

    @Autowired
    private DemoService demoService;
    
    @Autowired
    private MwSendSmsService mwSendSmsService;
    
    @Autowired
    private SensitivewordService sensitivewordService;
    
    private static final Integer testInteger = 1;

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
    
    @Test
    public void httpTest(){
//	    SendSmsOrder order = new SendSmsOrder ();
//	    order.setPhoneNum ("15923076029");
//	    order.setOrderNo ("DD585");
//	    order.setSendSmsEnum (SendSmsEnum.VERIFICATION_CODE);
//	    System.out.println (mwSendSmsService.sendSms (order));
	    HttpClientUtils httpClientUtils = new HttpClientUtils ();
	
	    String s = httpClientUtils.doGet ("https://test.kxg99.com/goods/recharge/CashNotify");
	    System.out.println (s);
    }
    
    
    
    @Test
    public void sensitiveWordInsertTest(){
	    SimpleResult result = sensitivewordService.batchInsert ("1,2");
	    System.out.println (result);
    }
	
	@Test
	public void sensitiveWordDelTest(){
		SimpleResult result = sensitivewordService.batchDelete ("1,2");
		System.out.println (result);
	}
	
	@Test
	public void sensitiveWordTest(){
//		SensitiveWordResult all = sensitivewordService.findAll ();
		String str = sensitivewordService.replaceSensitiveWord ("芽儿哦", "*");
		System.out.println (str);
	}
	
	/*@Test
	public void InsertUserTest(){
		SimpleUserOrder order = new SimpleUserOrder ();
		order.setUsername ("824230187");
		order.setPassword ("jf123456");
		order.setSex (1);
//		System.out.println (extraMapper.getSysdate ());
		System.out.println (demoService.insertNewData (order));
	}*/
	
    
    public static void main (String[] args) {
//		String randomNumeric = RandomStringUtils.randomNumeric (6);
//		System.out.println (randomNumeric);
        /*int i = 11;
        do {
	        System.out.print ("z");
	        i--;
        }while (i>7);
        
        long num =100L;
        
        float f = num;
        
        float f2 = 100F;
        
        long l2 = (long)f2;*/
        
        /*int [] [] arr = {{1,2},{1},{4,5,6},{}};
	
	    System.out.println (arr[0].length);
	    System.out.println ("7117102755926884276".length ());*/
        /*String str = "您的手机验证码为:#code,请及时输入!";
	    System.out.println (str.replace ("#code", RandomStringUtils.randomNumeric (6)));
	    int [] arr = {1,2,3,5,6,7,8,9,0};*/
	    
       /* List<UserTest> list = new ArrayList<> ();
        UserTest userTest1 = new UserTest ();
        userTest1.setUsername ("liujianfu");
        UserTest userTest2 = new UserTest ();
        list.add (userTest1);
	    list.add (userTest2);
	    System.out.println (list);
	    list.remove (userTest1);
	    System.out.println (list);*/
	
	    BigDecimal b1 = new BigDecimal ("1200.00");
	    BigDecimal b2 = new BigDecimal ("44444.00");
	    System.out.println (b1.divide (b2,2));
    }
	

}