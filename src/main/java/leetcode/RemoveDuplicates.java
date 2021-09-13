package leetcode;

/**
 * 删除排序数组中的重复项 II
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * @author jzt
 * @version 1.0
 * @date 2021-02-22 20:30
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len<2){
            return len;
        }
        int slow = 0;
        int res = 1;
        int sameCount = 1;
        for (int fast=1;fast<len;fast++){
            boolean diff = nums[slow]!=nums[fast];

            //如果下标i和下标j的值不相同
            if (diff){
                res++;
                slow++;
                sameCount = 1;
                nums[slow]=nums[fast];
            }
            //如果下标i和下标j的值相同
            if (!diff){
                sameCount++;
            }

            //如果下标i和下标j的值相同并且当前相同的数字小于2
            if (!diff&&sameCount<3){
                res++;
            }
            if (!diff&&sameCount<3){
                slow++;
            }
            //如果下标i和下标j的值相同但是当前相同的数字大于等于2
            //等于2很关键
            if (!diff&&sameCount>=2){
                nums[slow]=nums[fast];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});

    }

}
