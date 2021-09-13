package leetcode;

/**
 * 买卖股票的最佳时机
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 股票问题核心思路
 * 记录持有股票卖出  和 没有股票买入的价格
 * 然后进行买入或者卖出 获取最大的收益
 * @author jzt
 **/
public class MaxProfit {
    public static  int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int buy = 0-prices[0];
        int sell = 0;
        for (int index = 1;index<prices.length;index++){
            sell = Math.max(sell,prices[index]+buy);
            //买出是否有收益  如果没有收益说明上次买入不合理  那么重新买入
            if (buy+prices[index]<=0){
                buy = 0-prices[index];
            }
        }
        return sell;
    }


    /**
     * 买卖股票的最佳时机卖出时含手续费
     *
     * 构造DP
     * DP[i][0] 代表手上没有股票的收益
     * DP[i][1] 代表手上有一只股票的收益
     * DP[i][0]的状态转移方程 {
     *      dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]−fee}
     * }
     *
     * DP[i][1]的状态转换方程 {
     *     dp[i][1]=max{dp[i−1][1],dp[i−1][0]-prices[i]}
     * }
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     *
     *
     **/
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
    /**
    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        Map<Integer, List<Integer>> dp = new HashMap<>();
        for (int i = 0;i<len;i++){
            for (int j = 0;j<len;j++){
                if (j>=i){
                    if (prices[j]-prices[i]-fee>0){
                        if (!dp.containsKey(i)){
                            dp.put(i,new ArrayList<>());
                        }
                        dp.get(i).add(j);
                    }
                }
            }
        }
        int max = 0;
        for (Integer buy : dp.keySet()) {
            max = Math.max(max,buySell(prices,fee,buy,0,dp));
        }
        return max;
    }

    private static int buySell(int[] prices, int fee,int buy,int profit,Map<Integer, List<Integer>> dp){
        //是否存在后续交易
        if (!dp.containsKey(buy)){
            return profit+0;
        }
        int currentProfit = 0;
        for (int index=0;index<dp.get(buy).size();index++){
            int sell = dp.get(buy).get(index);
            int tempProfit = prices[sell]-prices[buy]-fee;
            if (index+1<dp.get(buy).size()){
                tempProfit=buySell(prices, fee,dp.get(buy).get(index+1),tempProfit+profit,dp);
            }
            currentProfit =Math.max(tempProfit,currentProfit);
        }
        return Math.max(currentProfit+profit,currentProfit);
    }
    */

    /**
     * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     *
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     *
     **/
    public int maxProfitIII(int[] prices) {
        if (prices==null||prices.length<2){
            return 0;
        }
        if (prices.length==2){
            if (prices[1]>prices[0]){
                return prices[1]-prices[0];
            }
            return 0;
        }
        int[][] dp = new int[2][prices.length];
        dp[0][0] = -prices[0];
        dp[1][0] = 0;
        dp[0][1] = -prices[1];
        dp[1][1] = prices[1]-prices[0];
        dp[0][2] = -prices[2];
        dp[1][2] = maxHelp(dp[0],1)+prices[2];
        for (int i = 3; i < prices.length; i++) {
            //买
            dp[0][i] = maxHelp(dp[1],i-2)-prices[i];
            //卖
            dp[1][i] = maxHelp(dp[0],i-1)+prices[i];
        }
        return maxHelp(dp[1],prices.length-1);
    }

    private int minHelp(int[] eles,int index){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= index; i++) {
            min = Math.min(min,eles[i]);
        }
        return min;
    }

    private int maxHelp(int[] eles,int index){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= index; i++) {
            max = Math.max(max,eles[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfitIII(new int[]{1,2,3,0,2}));
//        System.out.println(maxProfit(new int[]{1,4,6,2,8,3,10,14},3));
    }
}
