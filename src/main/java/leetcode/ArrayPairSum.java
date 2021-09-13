package leetcode;

import java.util.Arrays;

/**
 * 数组拆分 I
 * https://leetcode-cn.com/leetbook/read/array-and-string/c24he/
 * @author jzt
 * @version 1.0
 * @date 2021/4/21 8:02 下午
 **/
public class ArrayPairSum {

    public int arrayPairSum(int[] nums) {
        if (nums==null){
            return 0;
        }
        Arrays.sort(nums);
        int l=0,r=nums.length-1,min=0;
       while (l>r){
           min+=Math.abs(Math.subtractExact(nums[r--],nums[l++]));
       }
       return min;
    }
}
