package leetcode;

import java.util.Arrays;

/**
 * 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/
 * @Date 2020-09-01 19:38
 **/
public class PredictTheWinner {

    public static boolean predictTheWinner(int[] nums) {
        int total = total(nums);
        int sum = 0 ;
        for (int index = 0;index<nums.length/2;index++) {
            if (index==0 || index%2 != 0){
                sum = sum(sum,nums);
                if (total/2<sum){
                    return true;
                }

            }
            if (nums[0]>=nums[nums.length-1]){
                nums = Arrays.copyOfRange(nums,1,nums.length-1);
            }else {
                nums = Arrays.copyOfRange(nums,0,nums.length-2);
            }

        }
        return false;
    }

    public static int total(int[] nums){
        int sum = 0;
        for (int index = 0;index<nums.length;index++) {
            sum+=nums[index];
        }
        return sum;
    }

    public static int sum(int sum,int[] nums){
        return sum + Math.max(nums[0],nums[nums.length-1]);
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1,5,233,7}));
    }

}
