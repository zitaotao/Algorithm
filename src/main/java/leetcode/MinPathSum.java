package leetcode;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 * @author jzt
 * @version 1.0
 * @date 2021/7/1 10:52 上午
 **/
public class MinPathSum {
    /**
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     *
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     **/
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                //当前值等于上面的+this 和左面的+this的最大值
                if (i==0){
                    if (j==0){
                        dp[0][0] = grid[0][0];
                    }else{
                        dp[0][j] = dp[0][j-1]+grid[0][j];
                    }
                }
                else if (j==0){
                    dp[i][0] = grid[i][0]+dp[i-1][0];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        new MinPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
}
