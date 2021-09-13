package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文字串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 **/
public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        int n = s.length();
        //dp[l,i]表示s.sub(l,i)是不是回文串
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    //单个字符都是相等的
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                //取子串的最大值
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    public static String longestPalindromeII(String s) {
        return help(s);
    }

    public static String help(String s){
        if(s==null||s.length()==0){
            return "";
        }
        if (s.length()==1){
            return s;
        }
        int mid = s.length()/2;
        if(s.length()%2==0){
            s = s.substring(0,mid) + "." + s.substring(mid);
        }
        mid = s.length()/2;
        int l = mid-1,r=mid+1;
        StringBuilder son = new StringBuilder(s.charAt(mid));
        String lSon = "";
        String rSon = "";
        while (r<s.length()){
            if(s.charAt(l) != s.charAt(r)){
                lSon = help(s.substring(0,mid+1).replace(".",""));
                rSon = help(s.substring(mid).replace(".",""));
                String temp = lSon.length()>rSon.length() ? lSon.replace(".",""):rSon.replace(".","");
                return  son.toString().length()>temp.length() ? son.toString().replace(".",""):temp.replace(".","");
            }
            son.append(s.charAt(l--)).append(s.charAt(mid)).append(s.charAt(r++));
        }
        return son.toString().replace(".","");
    }
    private String[] sArray;
    public String longestPalindromeIII(String s) {
        if (s==null||s.equals("")){
            return "";
        }
        if (s.length()==1){
            return s;
        }
        int len = s.length()*2+1;
        String sub = "";
        sArray= new String[len];
        sArray[0]="#";
        int j=1;
       for ( String e :s.split("")){
           sArray[j++] = e;
           sArray[j++] = "#";
       }
       for (int i=0;i<len;i++){
            String t = helpIII(i);
            sub = t.length()>sub.length()?t:sub;
        }
        return sub.replaceAll("#","");
    }

    public String helpIII(int center) {
        String sub = sArray[center];
        int l = Math.max(center-1,0);
        int r = Math.min(center+1,sArray.length-1);
        while (l>0&&r<sArray.length){
            if (sArray[l].equals(sArray[r])){
                sub = sArray[l]+sub+sArray[r];
            }else {
                return sub;
            }
            l--;
            r++;
        }
        return sub;
    }

    public static void main(String[] args)
    {
        System.out.println(new LongestPalindrome().longestPalindromeIII("abbc"));
    }

}
