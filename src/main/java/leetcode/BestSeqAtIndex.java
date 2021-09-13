package leetcode;

import java.util.Arrays;

/**
 * 马戏团人塔
 *
 * https://leetcode-cn.com/problems/circus-tower-lcci/
 **/
public class BestSeqAtIndex {

    public static int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; ++i){
            person[i] = new int[]{height[i], weight[i]};
        }
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0){
                i = -(i + 1);
            }
            dp[i] = pair[1];
            if (i == res){
                ++res;
            }
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(bestSeqAtIndex(new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181},new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594}));
    }
}
