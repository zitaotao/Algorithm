package leetcode;

/**
 * 最大子序和
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 **/
public class MaximumSubsequenceSum {
    public static int maxSubArray(int[] nums) {
        if (nums==null){
            return 0;
        }
        if (nums.length==0){
            return 0;
        }
        int max = nums[0];
        for (int index = 1 ;index<nums.length;index++){
            nums[index] = Math.max(nums[index]+nums[index-1],nums[index]);
            max = Math.max(nums[index],max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
