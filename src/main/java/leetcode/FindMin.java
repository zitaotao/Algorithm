package leetcode;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/leetbook/read/binary-search/xeawbd/
 * https://leetcode-cn.com/leetbook/read/binary-search/xetw7g/
 * @author jzt
 * @version 1.0
 * @date 2021-03-03 11:08
 **/
public class FindMin {
    public int findMin(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.min(nums[0],nums[1]);
        }
        int l = 0, r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if (nums[mid]<nums[mid+1]&&nums[mid]<nums[0]){
                r = mid;
            }
            if (nums[mid]<nums[mid+1]&&nums[mid]>nums[0]){
                l = mid+1;
            }
        }
        return nums[0];
    }

    /**
     * 解题思路
     * 比较 mid 和 mid+1的大小，判断当前属于上升还是下降的序列
     * 如果mid>mid+1 直接返回因为此时处于下降的序列
     * 如果mid<=mid+1
     * 判断
     * 如果 nums[mid]<=nums[r]&&nums[mid]<=nums[l]  此时无法确定当前属于升序还是降序时所以无法进行二分查找
     **/
    public int findMinII(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.min(nums[0],nums[1]);
        }
        int l = 0, r = nums.length-1;
        while (l<r){
            int mid = (l+r)/2;
            if (nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            //无法确定当前属于升序还是降序时
            if (nums[mid]<=nums[r]&&nums[mid]<=nums[l]){
                r = r-1;
            }
            if (nums[mid]<=nums[r]&&nums[mid]>nums[l]){
                r = mid;
            }
            if (nums[mid]<=nums[l]&&nums[mid]>nums[r]){
                l = mid+1;
            }
            //无法确定时候升序 还是降序 这个时候需要根据 nums[l] 和 nums[r]的值进行判断最小值在左侧还是右侧
            //如果nums[l]<=nums[r] 说明 最小值应该在左侧所以把右窗口缩小（因为此时无法判断升序还是降序所以无法进行二分只能滑动窗口）
            //如果nums[l]>nums[r] 说明 最小值应该在右侧 此时 l = mid+1 和 l = l+1都可以
            if (nums[mid]>=nums[r]&&nums[mid]>=nums[l]){
                if(nums[l]<=nums[r]){
                    r = r-1;
                    continue;
                }
                if(nums[r]<nums[l]){
                    l = mid+1;
                }
            }
        }
        return nums[l];
    }


    /**
     * 思路
     * 如果nums[len-1]>nums[0] 最小值为nums[0]
     * 如果nums[len-1]<nums[0] 最小值为nums[len-1]左侧数据
     **/
    public int findMinIII(int[] nums){
        if (nums==null){
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        if (nums[len-1]>nums[0]){
            return nums[0];
        }
        int l=0,r=len-1;
        while (l<r){
            int mid =l+(r-l)/2;
            if (nums[mid]>nums[r]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        new FindMin().findMinIII(new int[]{3,3,3,1});
    }

}
