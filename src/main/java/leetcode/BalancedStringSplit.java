package leetcode;

/**
 * 1221. 分割平衡字符串
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 *
 * @author jzt
 * @version 1.0
 * @date 2021/9/7 3:21 下午
 **/
public class BalancedStringSplit {

    public int balancedStringSplit(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int r = 0, l = 0, num = 0;
        for (int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
            if (str == 'R') {
                r++;
            }
            if (str == 'L') {
                l++;
            }
            if (r == l && r != 0) {
                num++;
                r = 0;
                l = 0;
            }
        }
        return num;
    }
}
