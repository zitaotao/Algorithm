package leetcode;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * @author jzt
 * @version 1.0
 * @date 2021-02-23 19:53
 **/
public class SortColors {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0,p1=0;
        for (int index=0;index<len;index++){
            int temp = nums[index];
            if (nums[index]==1){
                //交换1的值
                nums[index] = nums[p1];
                nums[p1] = temp;
                p1++;
            }else if (nums[index]==0){
                //交换0的值
                nums[index] = nums[p0];
                nums[p0] = temp;

                //p0<p1 的时候需要将当前值置后
                if (p0<p1){
                    temp = nums[index];
                    nums[index] = nums[p1];
                    nums[p1] = temp;

                }
                p0++;
                p1++;
            }
        }
    }
}
