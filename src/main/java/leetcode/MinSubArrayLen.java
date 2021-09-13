package leetcode;

/**
 * 请描述类的业务用途
 * 长度最小的子数组
 * @author jzt
 * @version 1.0
 * @date 2021-02-28 16:55
 **/
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums==null){
            return 0;
        }
        if (nums.length==1){
            if (nums[0]>target){
                return 1;
            }
            return 0;
        }
        int left = 0;
        int ritht = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int index = 0;index<nums.length;index++){
            sum +=nums[index];
            ritht++;
            if (sum>=target){
                if (nums[index]>=nums[left]){
                    //缩小窗口
                    for (int i=left;i<=ritht;i++){
                        if (sum-nums[i]>=target){
                            left++;
                            sum -= nums[i];
                        }else {
                            break;
                        }
                    }
                }
                res = Math.min(res,ritht-left);
            }
        }
        if (sum<target){
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        new MinSubArrayLen().minSubArrayLen(5,new int[]{2,3,1,1,1,1,1});
    }
}
