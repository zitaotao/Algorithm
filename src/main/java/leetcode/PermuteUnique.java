package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author jzt
 * @version 1.0
 * @date 2021/9/8 11:16 上午
 **/
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums==null||nums.length==0){
            return new ArrayList<>();
        }
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        if (nums.length==1){
            List<List<Integer>> res = new ArrayList<>();
            res.add(numsList);
            return res;
        }
        return help(numsList);

    }

    public List<List<Integer>> help(List<Integer> nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.size()==2){
            res.add(new ArrayList<>(nums));
            Collections.reverse(nums);
            res.add(nums);
            return res.stream().distinct().collect(Collectors.toList());
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> sub = new ArrayList<>(nums);
            sub.remove(i);
            List<List<Integer>> son = help(sub);
            for (List<Integer> eles : son) {
                eles.add(nums.get(i));
            }
            res.addAll(son);
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new PermuteUnique().permuteUnique(new int[]{1,1,2});
    }
}
