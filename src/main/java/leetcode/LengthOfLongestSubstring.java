package leetcode;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author jzt
 * @version 1.0
 * @date 2021/5/23 12:16 下午
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 1;
        if (s==null){
            return 0;
        }
        if (s.length()==0){
            return 0;
        }
        StringBuilder sub = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = sub.indexOf(String.valueOf(s.charAt(i)));
            if (index>-1){
                max = Math.max(max,sub.length());
                sub  = new StringBuilder(sub.substring(index+1)+s.charAt(i));
                continue;
            }
            sub.append(s.charAt(i));
            max = Math.max(max,sub.length());
        }
        return max;
    }

    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }

}
