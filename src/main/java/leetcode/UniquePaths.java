package leetcode;

/**
 * 不同路径
 * 构造DP
 * https://leetcode-cn.com/problems/unique-paths/
 **/
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][n-1] = 1;
        for (int i =0;i<m;i++){
            for (int j =n-1;j>=0;j--){
                if (i==0&&j==n-1){
                    continue;
                }
                int left = i==0?0:dp[i-1][j];
                int on = j==n-1?0:dp[i][j+1];
                dp[i][j] =left  + on;
            }
        }
        return dp[m-1][0];
    }

    public static void main(String[] args) {
        System.out.println( uniquePaths(3,2));
    }
}
