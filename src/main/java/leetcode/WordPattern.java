package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 * 单词规律
 * @Author user
 * @Date 2020-12-16 10:18
 * @Version 1.0
 **/
public class WordPattern {
    /**
     * 思路：
     *
     * 记录单词出现的位置和数量
     * 记录模式单个字符出现的位置和数量
     * 然后比较两者位置和数量是否一致
     **/
    public static boolean wordPattern(String pattern, String s) {
        if ((pattern == null) || pattern.equals("") || (s == null) || s.equals("") || (pattern.length() != s.split(" ").length)){
            return false;
        }
        String [] strArray = s.split(" ");
        //模式 key是模式的单个字符  v 是每个字符出现的位置
        Map<String, List<Integer>> dp  = new HashMap<>();
        //单词 key是单词  v 是每个单词出现的位置
        Map<String, List<Integer>> sdp  = new HashMap<>();
        for (int index = 0 ;index<pattern.length();index++) {
            String str = pattern.substring(index,index+1);

            if (!dp.containsKey(str)){
                dp.put(str,new ArrayList<>());
            }
            dp.get(str).add(index);

            if (!sdp.containsKey(strArray[index])){
                sdp.put(strArray[index],new ArrayList<>());
            }
            sdp.get(strArray[index]).add(index);

            if (dp.get(str).size()!=sdp.get(strArray[index]).size()){
                return false;
            }
            for (Integer integer : dp.get(str)) {
                if (!sdp.get(strArray[index]).contains(integer)){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","a a a a"));
    }
}
