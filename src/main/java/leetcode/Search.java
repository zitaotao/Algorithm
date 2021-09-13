package leetcode;

/**
 * 二分查找
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @author jzt
 * @version 1.0
 * @date 2021-03-01 10:20
 **/
public class Search {
    /**
     * 简单的二分查找
     **/
    public int search1(int[] nums, int target,int left ,int right) {
//        int left = 0;
//        int right = nums.length-1;
        int mid = 0;
        while (left<=right){
            mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid]>target){
                right = mid-1;
            }

            if (nums[mid]<target){
                left = mid+1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums==null){
            return -1;
        }
        if (nums.length==1){
            if (target==nums[0]){
                return 0;
            }
            if (target!=nums[0]){
                return -1;
            }
        }
        int fast = 1;

        for (;fast<nums.length;fast++){
            if (nums[fast-1]>nums[fast]){
                break;
            }
            if (fast==nums.length-1){
                break;
            }
        }
        if (target<=nums[nums.length-1]&&target>=nums[fast]){
            return search1(nums,target,fast,nums.length-1);
        }

        if (target<=nums[fast-1]&&target>=nums[0]){
           return search1(nums,target,0,fast-1);
        }
        return search1(nums,target,0,nums.length-1);
    }


    public static void main(String[] args) {
        new Search().search(new int[]{1,3},1);
    }
}
