package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 完全平方数
 *
 * 思路  状态转换方程
 * 设 比x小的平方数为 [y1,y2,y3,y4....]
 * f(x) = Min(f(x-y)+1))
 *
 * https://leetcode-cn.com/problems/perfect-squares/
 **/
public class NumSquares {
    public static  int numSquares(int n) {
        if (n==0||n==1){
            return n;
        }

        int[] preSquare = new int[n];
        preSquare[0]=1;
        int preSquareIndex = 1;
        Map<Integer,Integer> dp = new HashMap();
        dp.put(1,1);
        for (int index = 2;index<=n;index++){
            int sqrt = (int) Math.sqrt(index);
            if (sqrt*sqrt == index){
                dp.put(index,1);
                preSquare[preSquareIndex++] = index;
            }else {
                dp.put(index,Integer.MAX_VALUE);
                for (int i =preSquareIndex-1;i>=0;i--){
                    dp.put(index,Math.min(dp.get(index-preSquare[i])+1,dp.get(index)));
                }

            }
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println( numSquares(12));
    }
}
