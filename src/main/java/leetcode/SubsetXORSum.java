package leetcode;

import java.util.Arrays;

/**
 * 找出所有子集的异或总和再求和
 * https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals/
 *
 * @author jzt
 * @version 1.0
 * @date 2021/8/26 11:20 上午
 **/
public class SubsetXORSum {

    public int subsetXORSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < (1 << nums.length); i++) {
            Integer xor = null;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) > 0) {
                    if (xor==null){
                        xor=nums[j];
                    }else {
                        xor^=nums[j];
                    }
                }

            }
            if (xor!=null) {
                sum += xor;
            }

        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new SubsetXORSum().subsetXORSum(new int[]{5, 1,6}));
    }

}
