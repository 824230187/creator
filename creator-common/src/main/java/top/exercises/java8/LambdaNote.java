package top.exercises.java8;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName LambdaNote
 * @Author liujf
 * @Date 2018/12/12 上午11:46
 * @Version 1.0
 */
public class LambdaNote {

    /**
     * lambda表达式学习笔记
     *  */

    /**
     * 遍历demo
     * @return void
     */
    public static void loop(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.forEach(p->{
            System.out.println(p);
        });

        //map容量计算：哈希表中条目的数目 容量乘加载因子 (0.75) 尽量用2^n次方
        Map<Integer, String> map = new HashMap<>(4);
        map.put(1, "lala");
        map.put(2, "lolo");
        map.forEach((k,v) ->{
            System.out.println(k+":"+v);
        });

    }


    /**
     * 排序
     * @return void
     */
    public static void sort(){
        List<String> list = new ArrayList<>();
        list.add("Criss");
        list.add("Bob");
        list.add("Alex");

        Collections.sort(list, (s1, s2)->s1.compareTo(s2));
        list.forEach(s -> System.out.println(s));

    }


    /**
     * Stream 流式编程demo 新stream 针对集合的操作
     * @return void
     */
    public static void sDemo1(){
        List<String> list = Arrays.asList(new String[] {"Copy", "Move"});
        //将list中的元素转成大些输出到一个新的set集合
        //方式1
        Set<String> collect = list.stream().map(string -> {
            String newStr = string.toUpperCase();
            return newStr;
        }).collect(Collectors.toSet());
        collect.forEach(v -> System.out.println(v));

        //方式2  方法引用
        //转为全小写
        List<String> lowList = collect.stream().map(String::toLowerCase).collect(Collectors.toList());
        lowList.forEach(v-> System.out.println(v));

    }


    /**
     * Stream demo2 过滤操作
     * @return void
     */
    public static void sDemo2(){
        //过滤字符集合中包含'.'的元素
        List<String> list = Lists.newArrayList("Alex","C.C.","lu.lu");
        //计算个数
        long count = list.stream().filter(p -> p.indexOf(".") != -1).count();
        //过滤
        List<String> collect = list.stream().map(s -> {
            if (s.indexOf(".")!= -1) {
                String ns = s.replace(".", " ");
                return ns;
            }
            return s;
        }).collect(Collectors.toList());

        collect.forEach(System.out::print);
        System.out.println(count);

    }

    /**
     * Stream 去重操作
     * @return void
     */
    public static void sDemo3(){
        List<Integer> list = Lists.newArrayList(1,2,3,1,2,3);
        list = list.stream().distinct().collect(Collectors.toList());
        list.forEach(v-> System.out.println(v));
    }


    public static void main(String[] args) {
//        //遍历
//        loop();
//        //排序
//        sort();
//        //流式编程
//        sDemo1();
        sDemo2();
        sDemo3();
    }


}