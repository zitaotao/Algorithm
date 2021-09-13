package leetcode;

/**
 * 替换后的最长重复字符
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * @author jzt
 * @version 1.0
 * @date 2021-02-03 10:18
 **/
public class CharacterReplacement {
    /**
     * 解题思路：滑动窗口
     *
     **/
    public int characterReplacement(String s, int k) {
        //存储英文字母在窗口内出现的次数
        int [] letterArray = new int[26];
        //窗口的左端点
        int left =0;
        //窗口的右端点
        int right =0;
        int len = s.length();
        int maxLetter = 0;
        while (right<len){
            //得出索引，ASCLL码
            int index = s.charAt(right) - 'A';
            //记录字符出现的次数
            letterArray[index] = letterArray[index]+1;
            maxLetter = Math.max(maxLetter,letterArray[index]);
            if (maxLetter+k<right-left+1){
                letterArray[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}
