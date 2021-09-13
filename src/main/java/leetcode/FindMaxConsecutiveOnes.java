package leetcode;

/**
 * 最大连续1的个数
 * https://leetcode-cn.com/leetbook/read/array-and-string/cd71t/
 * @author jzt
 * @version 1.0
 * @date 2021/4/21 8:35 下午
 **/
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null){
            return 0;
        }
        if(nums.length==1){
            return nums[0]==1?1:0;
        }
        int s=0,iCount=0,jCount=0;
        while (s<nums.length){
            if (nums[s++]==1){
                jCount+=1;
            } else {
                iCount = Math.max(iCount,jCount);
                jCount=0;
            }
            if (s==nums.length){
                iCount = Math.max(iCount,jCount);
            }
        }
        return iCount;
    }
}
