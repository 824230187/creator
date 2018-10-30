package top.jf.hutool.convert;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.CharsetUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ConvertNote
 * @Author liujf
 * @Date 2018/10/30 11:29
 * @Version 1.0
 */
public class ConvertNote {
    /**
     * 类型转换笔记
     * 在Java开发中我们要面对各种各样的类型转换问题，尤其是从命令行获取的用户参数、从HttpRequest获取的Parameter等等，这些参数类型多种多样，
     * 我们怎么去转换他们呢？常用的办法是先整成String，然后调用XXX.parseXXX方法，还要承受转换失败的风险，
     * 不得不加一层try catch，这个小小的过程混迹在业务代码中会显得非常难看和臃肿。
     *
     * Convert类可以说是一个工具方法类，里面封装了针对Java常见类型的转换，用于简化类型转换。
     * Convert类中大部分方法为toXXX，参数为Object，可以实现将任意可能的类型转换为指定类型。
     * 同时支持第二个参数defaultValue用于在转换失败时返回一个默认值。
     * */
    public static void main(String[] args) {
        //转换为字符串
        Double i = 23.5D;
        Integer i2 = 26;
        String s = Convert.toStr(i);
        String s1 = Convert.toStr(i2);
        System.out.println("转字符串："+s+"  "+s1);

        //装换成高精度类型
        BigDecimal bigDecimal = Convert.toBigDecimal(i);
        BigDecimal bigDecimal1 = Convert.toBigDecimal(i2);
        System.out.println("转高精度："+bigDecimal+"   "+bigDecimal1+"  "+bigDecimal.getClass());

        //转换为指定数组
        String[] b = { "1", "2", "3", "4" };
        Integer[] integers = Convert.toIntArray(b);
        System.out.println("转换为指定数组："+integers);

        //转换为日期对象; 这个好
        String str = "2018-10-18 18:04:47";
        String str2 = "2018-11-18";
        System.out.println("转换为日期对象： 1-"+Convert.toDate(str)+" 2-"+Convert.toDate(str2));

        //字符串转16进制
        String s2 = Convert.toHex(str, CharsetUtil.CHARSET_UTF_8);
        System.out.println("转16进制："+s2);

        //16进制转字符串
        String s3 = Convert.hexToStr(s2, CharsetUtil.CHARSET_UTF_8);
        System.out.println("原字符串："+s3);

        //Unicode和字符串转换
        String s4 = Convert.strToUnicode(str);
        System.out.println("字符串转Unicode："+s4);

        //很熟悉吧？如果你在properties文件中写过中文，你会明白这个方法的重要性。
        System.out.println("Unicode转回字符串："+Convert.unicodeToStr(s4));

        //时间转换Convert.convertTime方法主要用于转换时长单位，比如一个很大的毫秒，我想获得这个毫秒数对应多少分：
        long time = 88103821;
        //源;当前时间单位;转换成目标单位
        long min = Convert.convertTime(time, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println("毫秒转分钟："+min);
        long day = Convert.convertTime(time, TimeUnit.MILLISECONDS, TimeUnit.DAYS);
        System.out.println("毫秒转天："+day);

        //金额大小写转换
        double price  = 65214.2315151D;
        System.out.println("金额大小写转换:"+Convert.digitToChinese(price));

        //包装类和原始类转换
        //去包装
        Class<?> wrapClass = Integer.class;
        Class<?> unWraped = Convert.unWrap(wrapClass);
        //包装
        Class<?> primitiveClass = long.class;
        Class<?> wraped = Convert.wrap(primitiveClass);
        System.out.println("去包装："+unWraped+"   包装："+wraped);

    }

}
