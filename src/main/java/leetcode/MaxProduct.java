package leetcode;

/**
 * 请描述类的业务用途
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/7 2:50 下午
 **/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        int[][] dp = new int[2][nums.length];
        System.arraycopy(nums, 0, dp[0], 0, nums.length);
        System.arraycopy(nums, 0, dp[1], 0,  nums.length);
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1] * nums[i], Math.max(nums[i], dp[1][i - 1] * nums[i]));
            dp[1][i] = Math.min(dp[1][i - 1] * nums[i], Math.min(nums[i], dp[0][i - 1] * nums[i]));

        }
        int max = dp[0][0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }

    public static void main(String[] args) {
        new MaxProduct().maxProduct(new int[]{2,-1,1,1});
    }
}
