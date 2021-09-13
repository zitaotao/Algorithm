package leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * https://leetcode-cn.com/problems/move-zeroes/
 * @author jzt
 * @version 1.0
 * @date 2021-01-17 17:03
 **/
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        if(nums==null){
            return;
        }
        int index = 0;
        int zero = -1;
        while(index<nums.length){
            if (nums[index]!=0){
                if (zero!=-1){
                    swap(zero,index,nums);
                    zero = zero+1;
                }
            }
            if (nums[index]==0&&zero==-1){
                zero = index;
            }
            index++;
        }
        return;
    }
    public static void swap (int zeroIndex,int index,int[] nums){
        int temp = nums[index];
        nums[index] = nums[zeroIndex];
        nums[zeroIndex] = temp;
    }

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
