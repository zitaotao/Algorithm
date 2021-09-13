package leetcode;

import java.util.Arrays;

/**
 * 请描述类的业务用途
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/2 11:05 上午
 **/
public class LongestConsecutive {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
     *
     **/
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        int len = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1]==1){
                len++;
            }else if (nums[i]-nums[i-1]>1){
                max = Math.max(len,max);
                len = 1;
            }
        }

        return Math.max(len,max);
    }

    public static void main(String[] args) {
        new LongestConsecutive().longestConsecutive(new int[]{1,2,0,1});
    }
}
