package leetcode;

/**
 * 按摩师
 *
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 **/
public class Masseur {

    public static int massage(int[] nums) {
        int pre = 0;
        int preAndpre = 0;
        int max = 0;
        for (int index = 0;index<nums.length;index++){
            max = Math.max(pre,preAndpre+nums[index]);
            preAndpre=pre;
            pre = max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
