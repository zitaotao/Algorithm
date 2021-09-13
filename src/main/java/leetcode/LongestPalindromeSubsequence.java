package leetcode;

/**
 * 最长回文子序列
 *
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 **/
public class LongestPalindromeSubsequence {
    public static int longestPalindromeSubseq(String s) {
        if (s==null || "".equals(s)){
            return 0;
        }
        String [] strArray = s.split("");
        int n=s.length();
        int[][] dp = new int[s.length()][s.length()];
        //初始化dp
        for (int index = 0 ;index<n;index++){
            dp[index][index]=1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (strArray[i].equals(strArray[j])) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return  dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("aaaa"));
    }
}
