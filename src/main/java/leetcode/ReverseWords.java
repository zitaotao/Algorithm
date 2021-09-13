package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 翻转字符串里的单词
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/solution/
 * @author jzt
 * @version 1.0
 * @date 2021/4/18 1:53 下午
 **/
public class ReverseWords {
    public String reverseWords(String s) {
        if (s==null){
            return "";
        }
        List<String> words = Arrays.asList(s.split(" ")).stream().filter(ele->{
            return !ele.equals("");
        }).collect(Collectors.toList());
        if (words.isEmpty()){
            return "";
        }
        StringBuilder reverseWords = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            reverseWords.append(" ").append(words.get(i));
        }
        return reverseWords.substring(1);
    }

    public String reverseWordsII(String s){
        int len = s.length();
        int l =len-1,mid = len,r=len;
        StringBuilder reverseWords = new StringBuilder();
        for (int i= len;i>0;i--){
            if (s.substring(l, mid).equals(" ")){
                if (!s.substring(mid, r).equals(" ")){
                    if (r-mid>0){
                        reverseWords.append(" ").append(s.substring(mid,r));
                    }
                    r = l;
                    mid=r;
                    l--;
                    continue;
                }
                l--;
                mid--;
                r--;
                continue;
            }
            mid--;
            l--;
        }
        if (r-mid>0){
            reverseWords.append(" ").append(s.substring(mid,r));
        }
        return reverseWords.substring(1);
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWordsII(" the sky is blue ");
    }
}
