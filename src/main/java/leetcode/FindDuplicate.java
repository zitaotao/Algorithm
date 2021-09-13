package leetcode;

import java.util.Arrays;

/**
 * 寻找重复数
 * https://leetcode-cn.com/leetbook/read/binary-search/xe6xnr/
 * @author jzt
 * @version 1.0
 * @date 2021-03-09 16:45
 **/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0 ;i<=nums.length-2;i++)
        {
            if (nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        new FindDuplicate().findDuplicate(new int[]{1,2,2});
    }

}
