package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最大整除子集
 * <p>
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 **/
public class LargestDivisibleSubset {
    /**
     *
     **/
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        //dp[0][i]代表选
        //dp[1][i]代表不选
        int[][] dp = new int[2][nums.length];
        List<Integer> like = new ArrayList<>();
        List<Integer> dislike = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[0][i] = 1;
                dp[0][i] = 0;
                like.add(nums[i]);
                continue;
            }
            //选
            List<Integer> likeTempLike = new ArrayList<>();
            likeTempLike.addAll(like);
            List<Integer> likeTempDisLike = new ArrayList<>();
            likeTempDisLike.addAll(dislike);
            if (like.size() >= 1 && nums[i] % like.get(like.size() - 1) == 0) {
                likeTempLike.add(nums[i]);
            } else if (like.size() == 1 && nums[i] % like.get(like.size() - 1) != 0) {
                likeTempLike.clear();
                likeTempLike.add(nums[i]);
            }
            if (dislike.size() >= 1 && nums[i] % dislike.get(dislike.size() - 1) == 0) {
                likeTempDisLike.add(nums[i]);
            } else if (dislike.size() == 1 && nums[i] % dislike.get(dislike.size() - 1) != 0) {
                likeTempDisLike.clear();
                likeTempDisLike.add(nums[i]);
            }
            //不选
            List<Integer> dislikeTempLike = new ArrayList<>();
            dislikeTempLike.addAll(like);
            List<Integer> dislikeTempDisLike = new ArrayList<>();
            dislikeTempDisLike.addAll(dislike);
            if (like.size() >= 1 && nums[i] % like.get(like.size() - 1) == 0) {
                //
            } else if (like.size() == 1 && nums[i] % like.get(like.size() - 1) != 0) {
                dislikeTempLike.clear();
                dislikeTempLike.add(like.get(like.size() - 1));
            }
            if (dislike.size() >= 1 && nums[i] % dislike.get(dislike.size() - 1) == 0) {
//                dislikeTempDisLike.add(nums[i]);
            } else if (dislike.size() == 1 && nums[i] % dislike.get(dislike.size() - 1) != 0) {
                dislikeTempDisLike.clear();
                dislikeTempDisLike.add(dislike.get(dislike.size() - 1));
            }
            like = new ArrayList<>();
            like.addAll(likeTempLike.size() >= likeTempDisLike.size() && likeTempLike.contains(nums[i]) ? likeTempLike : likeTempDisLike);
            dislike = new ArrayList<>();
            dislike.addAll(dislikeTempLike.size() >= dislikeTempDisLike.size() && !dislikeTempLike.contains(nums[i]) ? dislikeTempLike : dislikeTempDisLike);

        }
        List<Integer> res = like.size() > dislike.size() ? like : dislike;
        if (dislike.size() == like.size() && dislike.size() > 1) {
            if (dislike.get(1) % dislike.get(0) == 0) {
                return dislike;
            }
            if (like.get(1) % like.get(1) == 0) {
                return like;
            }
        }
        return res;
    }

    public List<Integer> largestDivisibleSubsetII(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        //dp代表
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        int index = 0;
        for (int i=dp.length-1;i>-1;i--){
            max = Math.max(max,dp[i]);
            if (max == dp[i]){
                index= i;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i=index;i>-1;i--){
            if (nums[index]%nums[i]==0&&dp[i]==(max-res.size())){
                res.add(nums[i]);
                //下标转换 must！！！！
                index = i;
            }
        }
        return res.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new LargestDivisibleSubset().largestDivisibleSubsetII(new int[]{2, 4, 6, 9, 19, 81, 729});
    }
}
