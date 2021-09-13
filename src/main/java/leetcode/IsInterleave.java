package leetcode;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

/**
 * 97. 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/
 * @author jzt
 * @version 1.0
 * @date 2021/8/25 11:37 上午
 **/
public class IsInterleave {

    /**
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
     * 输出：true
     **/
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        String min = s1.length()>s2.length()?s2:s1;
        String max = s1.length()>s2.length()?s1:s2;
        int s = 0;
        StringBuilder s4 = new StringBuilder();
        for (int i=0;i<s3.length();i++){
            char c = s3.charAt(i);
            char sc = min.charAt(s);
            if (c == sc){
                s++;
            }else {
                s4.append(c);
            }
        }
       return s4.toString().equals(max);
    }

    public static void main(String[] args) {
        System.out.println(new IsInterleave().isInterleave("aabcc","dbbca","aadbbcbcac"));

    }
}
