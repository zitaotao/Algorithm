package leetcode;

/**
 * 三步问题
 *
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 **/
public class WaysToStep {

    public static int waysToStep(int n) {
        long temp = 0;
        long one = 1;
        long two = 2;
        long three = 4;
        long max = 0;
        if (n==1){
            return (int) one;
        }
        if (n==2){
            return (int) two;
        }
        if (n==3){
            return (int) three;
        }
        for (int index = 4;index<=n;index++){
            max = (one + two + three)%1000000007;
            temp = three;
            three =max;
            one = two;
            two =temp;
            //127536175 752119970
        }
        return (int) max;
    }

    public static void main(String[] args) {
        System.out.println( waysToStep(76));
    }
}
