/*
 * www.jinvovo.com Inc.
 * Copyright (c) 2017 All Rights Reserved
 */
package top.jf.jedis;

import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.List;


/**
 * Created by IntelliJ IDEA
 * 〈类详细描述〉 <p>
 * 〈功能详细描述〉
 *
 * @author liujf
 * @date 2017/8/17
 * @time 9:37
 */
public class JedisDemo {
    
    private static Jedis jedis;
    
    /**
     * Redis的数据结构
     *  1.String形式字符串，通过get , set, incr, decr等方法操作
     *  2.存储Hash， 就是一个键值对（map）容器。 每一个Hash可以存储多达40E多个键值对
     *  3.存储链表List  push生产者插入元素， pop消费者取出元素。
     *  4.集合Set无序不允许出现重复元素 可进行差集sdiff、并集sunion、交集sinter运算 store 保证数据唯一性
     *  5.sorted-set 分数以实现有序 更新删除效率快  场景：排行榜，微博热门话题 zadd-key-grade-value
     *
     *   multi 开启事物(相当于关系型数据库的transaction)  exec提交(相当于commit)   discard回滚(rollback)
     *
     *   redis的数据都是存储在内存中（因此高性能）。为了让redis服务器在重启之后还能保持数据不丢失，我们就必须要将redis存储的数据持久化，在重启
     *   前将redis存储到内存中的数据同步到硬盘当中去。
     *
     *   redis持久化的两种方式：  1.RDB方式（间隔XX秒像数据库里写入数据及其快照）  2.AOF方式（日志形式）
     *
     *      * */
    public static void main (String[] args) {
	    /**
	     * 1.String
	     * */
        Jedis jedis = getJedis ();
        jedis.set ("car", "BWM");
        System.out.println (jedis.get ("car"));
//        jedis.decrBy ("num", 5);
//        jedis.decr ("num");
//        jedis.incr ("num");
//        jedis.incrBy ("num", 5);
//        jedis.append ("num", "Lv");
	    /**
        * 2.存储Hash  第一个参数为容器key值
        * */
	    List<String> hmget = jedis.hmget ("map", "name");
	    //选择XX号数据库
//	    jedis.select (0);
	    //移动指定key值到指定X号数据库
//	    jedis.move ("num",1);
	    
	    System.out.println (hmget+"  "+jedis.hlen ("map"));
    }
    
    /**
     * 获取Jedis连接池
     * */
    public static JedisPool getJedisPool(){
        //创建Redis连接池配置
        JedisPoolConfig config = new JedisPoolConfig ();
        //设置一个pool连接池至多可以分配多少jedis实例
        config.setMaxTotal (500);
        //设置连接池至多空闲数
        config.setMaxIdle (5);
        //最大等待响应时间100秒
        config.setMaxWaitMillis (1000 * 100);
        
        JedisPool jedisPool = new JedisPool (config, "127.0.0.1", 6379);
        
        return jedisPool;
    }
    
    
    /**
     * 获取Jedis实例
     * */
    public static Jedis getJedis(){
        try {
           jedis = getJedisPool ().getResource ();
        } catch (JedisConnectionException e) {
            throw new JedisConnectionException ("连接Redis服务器失败！");
        }
        return jedis;
    }
}
