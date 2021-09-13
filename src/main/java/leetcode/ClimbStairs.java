package leetcode;

/**
 * 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/
 **/
public class ClimbStairs {
    public static  int climbStairs(int n) {
        int max = 0;
        int pre = 2;
        int preAndPre = 1;
        if (n==1){
            return preAndPre;
        }
        if (n==2){
            return pre;
        }
        for (int index = 3;index<=n;index++){
            max = pre + preAndPre;
            preAndPre = pre;
            pre = max;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
