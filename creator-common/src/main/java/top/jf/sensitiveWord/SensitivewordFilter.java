package top.jf.sensitiveWord;

import java.util.*;

/**
 * 敏感词过滤
 */
public class SensitivewordFilter {

    public static int minMatchTYpe = 1;      //最小匹配规则
    public static int maxMatchType = 2;      //最大匹配规则
    private static HashMap sensitiveWordMap = null;

    public static void filterInit(List<String> datas) {
        sensitiveWordMap = Sensitivelexicon.addSensitiveWordToHashMap(datas);
    }

    /**
     * 替换敏感字字符
     * @author chenming
     * @date 2014年4月20日 下午5:12:07
     * @param txt
     * @param replaceChar 替换字符，默认*
     * @version 1.0
     */
    public static String replaceSensitiveWord(List<String> datas, String txt,String replaceChar){
        if (sensitiveWordMap == null) {
            filterInit(datas);
        }
        String resultTxt = txt;
        List<String> set = getSensitiveWord(txt, 1);     //获取所有的敏感词
        Iterator<String> iterator = set.iterator();
        String word = null;
        String replaceString = null;
        while (iterator.hasNext()) {
            word = iterator.next();
            replaceString = getReplaceChars(replaceChar, word.length());
            resultTxt = resultTxt.replaceAll(word, replaceString);
        }
        return resultTxt;
    }

    /**
     * 获取替换字符串
     * @author chenming
     * @date 2014年4月20日 下午5:21:19
     * @param replaceChar
     * @param length
     * @return
     * @version 1.0
     */
    private static String getReplaceChars(String replaceChar,int length){
        String resultReplace = replaceChar;
        for(int i = 1 ; i < length ; i++){
            resultReplace += replaceChar;
        }
        return resultReplace;
    }

    /**
     * 获取内容中的敏感词
     * @param text 内容
     * @param matchType 匹配规则 1=不最佳匹配，2=最佳匹配
     * @return
     */
    public static List<String> getSensitiveWord(String text, int matchType) {
        List<String> words = new ArrayList<String>();
        Map now = sensitiveWordMap;
        int count = 0;  //初始化敏感词长度
        int start = 0; //标志敏感词开始的下标
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            now = (Map) now.get(key);
            if (now != null) { //存在
                count++;
                if (count ==1) {
                    start = i;
                }
                if ("1".equals(now.get("isEnd"))) { //敏感词结束
                    now = sensitiveWordMap; //重新获取敏感词库
                    words.add(text.substring(start, start + count)); //取出敏感词，添加到集合
                    count = 0; //初始化敏感词长度
                }
            } else { //不存在
                now = sensitiveWordMap;//重新获取敏感词库
                if (count == 1 && matchType == 1) { //不最佳匹配
                    count = 0;
                } else if (count == 1 && matchType == 2) { //最佳匹配
                    words.add(text.substring(start, start + count));
                    count = 0;
                }
            }
        }
        return words;
    }

    /**
     * 添加敏感词
     * @param str
     */
    public static boolean addSensitiveWord(String str) {
        Map nowMap = null;
        Map<String, String> newWorMap = null;
        if (sensitiveWordMap == null) {
            return false;
        }
        nowMap = sensitiveWordMap;
        Sensitivelexicon.func(str, nowMap, newWorMap);
        return true;
    }
}
