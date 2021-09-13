package leetcode;

/**
 * 寻找峰值
 * https://leetcode-cn.com/problems/find-peak-element/
 * @author jzt
 * @version 1.0
 * @date 2021-03-02 20:43
 **/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
       while (l<r){
           int mid = (l+r)/2;
           //当前元素处于局部增加的序列
           if (nums[mid]<nums[mid+1]){
               l = mid+1;
           }else {
               r = mid;
           }
       }
        return l;
    }
}
