package leetcode;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/leetbook/read/binary-search/xenp13/
 * @author jzt
 * @version 1.0
 * @date 2021-03-03 11:47
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return new int[]{-1,-1};
        }
        int l = 0 , r = nums.length-1;
        int lIndex = 0,rIndex = 0;
        //先处理左端点
        while (l+1<r){
            int mid = l + (r-l)/2;
            if (nums[mid] >= target){
                r = mid;
            }
            if (nums[mid]<target){
                l =mid;
            }
        }
        if (nums[l]!=target&&nums[r]!=target){
            return new int[]{-1,-1};
        }
        //选择更小的下标作为左端点
        lIndex = nums[l]==target?l:r;
        l = 0 ;
        r = nums.length-1;
        while (l+1<r){
            int mid = l + (r-l)/2;
            if (nums[mid]<=target){
                l = mid;
            }
            if (nums[mid]>target){
                r = mid;
            }
        }
        //选择更大的下标作为右端点
        rIndex = nums[r]==target?r:l;
        return new int[]{lIndex,rIndex};
    }


    public static void main(String[] args) {
        new SearchRange().searchRange(new int[]{5,7,7,8,8,10},8);
    }

}
