package leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * 739. 每日温度
 * @author jzt
 * @version 1.0
 * @date 2021/7/15 4:51 下午
 **/
public class DailyTemperatures {

    /**
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
     *
     * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
     *
     * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
     *
     **/
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dailyTemperatures = new int[temperatures.length];
        Arrays.fill(dailyTemperatures,0);
        int l = 0,r = 1;
        while (l<dailyTemperatures.length&&r<dailyTemperatures.length){
           if (temperatures[l]<temperatures[r]){
                dailyTemperatures[l] = r-l;
                l++;
                r = l;
            }
            r++;
           if (r>=dailyTemperatures.length){
               l++;
               r= l;
           }
        }
        return dailyTemperatures;
    }

    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{55,38,53,81,61,93,97,32,43,78});
    }
}
