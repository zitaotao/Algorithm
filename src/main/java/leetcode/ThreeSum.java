package leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 三数之和
 * @Author user
 * @Date 2020-12-13 10:34
 **/
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        int[][] dp  = new int[nums.length][nums.length];
//        for (int i =0;i<nums.length;i++){
//            for (int j =0;j<=i;j++){
//                if (i!=j){
//                    dp[i][j] = nums[i]+nums[j];
//                }
//            }
//        }
        for (int i =2;i<nums.length;i++){
           int currentNum = nums[i];
           for (int dpI = 1;dpI<i;dpI++){
               for (int dpJ = 0;dpJ<dpI;dpJ++){
                   dp[dpI][dpJ] = nums[dpI]+nums[dpJ];
                   if (dp[dpI][dpJ]+currentNum==0){
                       if (!map.containsKey(""+nums[dpI]+nums[dpJ]+currentNum)){
                           List<Integer> ele = Arrays.asList(nums[dpI],nums[dpJ],currentNum);
                           res.add(ele);
                           map.put(""+nums[dpI]+nums[dpJ]+currentNum,"");
                       }
                   }
               }
           }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
