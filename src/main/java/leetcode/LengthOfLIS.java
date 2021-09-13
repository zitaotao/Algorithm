package leetcode;

/**
 * 最长上升子序列
 *
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 **/
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int max = 1;
        int [] preMax = null;
        int[][] dp =new int[nums.length][nums.length];
        dp[0][0] = nums[0];
        for (int index = 1;index<nums.length;index++){
            //10,9,2,5,3,7,101,18
            for (int j = 0;j<=index;j++){

                if (nums[index]==dp[index-1][j]){
                    break;
                }
                if (nums[index]<dp[index-1][j]){
                    dp[index][j] = nums[index];
                    max = Math.max(max,len(dp[index]));
                    if (len(dp[index])<=len(dp[index-1])){
                        preMax = dp[index-1];
                    }
                    break;
                }else {
                    dp[index][j] =dp[index-1][j];
                }
                //选
                if (dp[index-1][j] == 0){
                    dp[index][j] = nums[index];
                    max = Math.max(max,len(dp[index]));
                    break;
                }
            }
            if (preMax !=null){
                //10,9,2,5,3,7,101,18

                if (len(dp[index])>len(preMax)){
                    preMax = dp[index];

                }else {
                    for (int j = 0;j<=preMax.length;j++){
                        if (nums[index]==dp[index-1][j]){
                            break;
                        }
                        if (nums[index]<preMax[j]){
                            dp[index][j] = nums[index];
                            max = Math.max(max,len(dp[index]));
                            break;
                        }else {
                            dp[index][j] =preMax[j];
                        }
                        //选
                        if (preMax[j] == 0){
                            dp[index][j] = nums[index];
                            max = Math.max(max,len(dp[index]));
                            break;
                        }
                    }
                }

            }
        }
        return max;
    }
    public static int len (int[] array){
        int len = 0;
        for (int index = 0;index<array.length;index++){
            if (array[index]==0){
                return len;
            }
            len++;
        }
        return len;
    }
    public static void main(String[] args) {

        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,4}));
    }
}
