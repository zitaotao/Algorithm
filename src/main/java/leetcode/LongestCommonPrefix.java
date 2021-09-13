package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/leetbook/read/array-and-string/ceda1/
 * @author jzt
 * @version 1.0
 * @date 2021-04-12 19:50
 **/
public class LongestCommonPrefix {
    /**
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     **/
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0){
            return "";
        }
        Arrays.sort(strs, Comparator.comparing(String::length));
        String commonPrefix = strs[0];
        for (int index=1;index<strs.length;index++){
            commonPrefix = help(strs[index],commonPrefix);
        }
        return commonPrefix;
    }

    public String help(String a , String b){
        if (a.length()==0||b.length()==0){
            return "";
        }
        int len = Math.min(a.length(), b.length());
        StringBuilder commonPrefix = new StringBuilder();
        for (int index=0;index<len;index++){
            if (!a.substring(index,index+1).equals(b.substring(index,index+1))){
                return commonPrefix.toString();
            }
            commonPrefix.append(a.charAt(index));
        }
        return commonPrefix.toString();
    }
    public static void main(String[] args) {
        new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
