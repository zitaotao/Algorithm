package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 连续数列
 *
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 **/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        boolean allNegativeNumber = true;
        int maxNegativeNumber = Integer.MIN_VALUE;
        int max = 0;
        //从上一个正数到pre位置的和
        int preValue = 0;
        for (int index = 0;index<nums.length;index++){
           if (nums[index]>0){
               allNegativeNumber = false;
               max = Math.max(max,Math.max(preValue+nums[index],nums[index]));
               preValue = Math.max(preValue+nums[index],nums[index]);
           }else {
               if (maxNegativeNumber<nums[index]){
                   maxNegativeNumber = nums[index];
               }
               preValue = preValue+nums[index];
           }
        }
        if (allNegativeNumber){
            return maxNegativeNumber;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{8,-19,5,-4,20}));
    }
}
