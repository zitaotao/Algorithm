package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 * 860. 柠檬水找零
 * @Author user
 * @Date 2020-12-10 19:04
 * @Version 1.0
 **/
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        List<Integer> five = new ArrayList<>();
        List<Integer> ten = new ArrayList<>();
        List<Integer> twenty = new ArrayList<>();
        for (int bill : bills) {
            if (bill==5){
                five.add(bill);
            }

            if (bill==10){
                if (!five.isEmpty()){
                    five.remove(five.size()-1);
                    ten.add(bill);
                }else {
                    return false;
                }
            }

            if (bill==20){
                if (five.isEmpty()){
                    return false;
                }
                if (!ten.isEmpty()){
                    five.remove(five.size()-1);
                    ten.remove(ten.size()-1);
                    twenty.add(bill);
                }else if(five.size()>=3){
                    five.remove(five.size()-1);
                    five.remove(five.size()-1);
                    five.remove(five.size()-1);
                    twenty.add(bill);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
