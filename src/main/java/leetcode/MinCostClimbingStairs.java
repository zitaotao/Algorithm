package leetcode;

/**
 * 使用最小花费爬楼梯
 *
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 **/
public class MinCostClimbingStairs {
    public static  int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost,0),minCostClimbingStairs(cost,1));
    }

    public static  int minCostClimbingStairs(int[] cost,int startIndex) {
        int pre =  Math.min(cost[startIndex],cost[startIndex+1]);
        int preAndPre = Math.min(cost[startIndex],cost[startIndex+1]);
        int min = 0;
        for (startIndex=startIndex+2;startIndex<cost.length;startIndex++){
            min = Math.min(pre+cost[startIndex],preAndPre+cost[startIndex]);
            preAndPre = pre;
            pre = min;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
