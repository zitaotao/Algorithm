package leetcode;

/**
 *
 * 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/
 **/
public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int w = obstacleGrid.length;
        int h = obstacleGrid[0].length;
        int[] dp = new int[h+1];
        dp[1] = 1;

        for (int i = 1; i <= w; i++){
            for (int j = 1; j <= h; j++){
                dp[j] = obstacleGrid[i-1][j-1] == 1 ? 0 : dp[j] + dp[j-1];
            }

        }
        return dp[h];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid ={{0,0},{0,1}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
