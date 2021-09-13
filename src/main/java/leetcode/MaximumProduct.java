package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 * 三个数的最大乘积
 * @author jzt
 * @version 1.0
 * @date 2021-01-20 19:48
 **/
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
