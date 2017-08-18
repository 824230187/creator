/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import top.jf.entity.UserTest;
import top.jf.json.eneity.UserEntity;

import java.io.*;

/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/8/16
 * @time 9:38
 */
public class GsonDemo {
    
    /**
     * Gson是google公司发布的用于解析json的工具
     * */
    public static void main (String[] args) {
        
        /**
         * 1.利用Gson将对象解析成对应的Json字符串
         * */
        UserTest user = new UserTest ();
        user.setPassword ("12345");
        user.setUsername ("C.C");
        user.setSex (1);
        
        //Gson gson = new Gson ();
        GsonBuilder builder = new GsonBuilder ();
        //pretty输出和格式化日期
        Gson gson = builder.setPrettyPrinting ().setDateFormat ("yyyy-MM-dd").create ();
        String str = gson.toJson (user);
        System.out.println (str);
        
        /**
         *  2.利用Gson对Json字符串进行反解析。将其转换成指定JavaBean
         * */
        System.out.println ("==============反解析=================");
        //获取json字符串
        GsonDemo gsonDemo = new GsonDemo ();
        String jsonStr = gsonDemo.getJsonStr ("test.json");
        System.out.println (jsonStr);
        UserEntity userEntity = gson.fromJson (jsonStr, UserEntity.class);
        System.out.println (userEntity.toString ());
        System.out.println ("格式化后的日期类型："+userEntity.getBirthday ().getClass ());
        
        
        /**
         * 3.Gson对于数组和集合的无缝对接
         * */
        System.out.println ("==============数组和集合无缝对接=================");
        System.out.println ("集合类型："+userEntity.getHobbyList ().getClass ());
        System.out.println ("数组类型："+userEntity.getHobbyArr ().getClass ());
        
            
        /**
         * 4.对于JSONObject的一些补充
         *  (1)new JSONObject 后进行put。
         *  (2)通过传入Map参数值将Map转换成JSONObject
         *  (3)在现有对象的基础上（已经给对象Set了值），new JSONObject(obj)
         *  (4)对于json中不同数据类型，对应不同JSONObject.getXXX("key")方法
         *  (5)如果要获取数组，则需要JSONObect.getJSONArray()，对其进行遍历
         *   javaBean->json   反解析json->javaBean
         * */
    }
    
    private String getJsonStr(String fileName){
        return readJson (this.getClass ().getClassLoader ().getResource (fileName).getPath ());
    }
    
    private static String readJson (String path) {
        //从给定位置获取文件
        File file = new File(path);
        BufferedReader reader = null;
        //返回值,使用StringBuffer
        StringBuffer data = new StringBuffer();
        //
        try {
            reader = new BufferedReader(new FileReader (file));
            //每次读取文件的缓存
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                data.append(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件流
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();
    }
    
}
