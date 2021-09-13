package leetcode;


/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * https://leetcode-cn.com/problems/jump-game/
 * @author jzt
 * @version 1.0
 * @date 2021/6/30 3:10 下午
 **/
public class CanJump {
    /**
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     *
     **/
    public boolean canJump(int[] nums) {
        if (nums==null||nums.length==0){
            return true;
        }

        if (nums.length==1&&nums[0]==0){
            return true;
        }
        int zeroIndex = help(nums);
        // if (zeroIndex==nums.length-1){
        //     return false;
        // }
        if (zeroIndex==-1){
            return true;
        }
        int l = 0;
        for (int i =0;i<zeroIndex;i++){
            if (nums[i]-zeroIndex+i>0){
                return true;
            }

            if (nums[i]==0&&i<zeroIndex&&nums[i+1]!=0){
                boolean temp = false;
                for (int j =l;j<i;j++){
                    if (nums[j]-i+j>0){
                        temp = true;
                        break;
                    }
                    l = i+1;
                }
                if (!temp){
                    return false;
                }

            }

            if (nums[i]-zeroIndex+i==0&&zeroIndex==nums.length-1){
                return true;
            }
        }
        return false;
    }

    public int help(int[] nums){
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                zeroIndex = i;
            }
        }
        return zeroIndex;
    }

    public boolean canJumpII(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
    }
}
