package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode-cn.com/problems/subsets/
 * @author jzt
 * @version 1.0
 * @date 2021/9/7 3:48 下午
 **/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums==null||nums.length==0){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1<<nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i&(1<<j))>0){
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }


}
