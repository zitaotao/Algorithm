package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  全排列
 * https://leetcode-cn.com/problems/permutations/
 * @author jzt
 * @version 1.0
 * @date 2021/6/30 1:57 下午
 **/
public class Permute {
    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     **/
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length==0){
            return new ArrayList<>();
        }
        if (nums.length==1){
            return Arrays.asList(Arrays.asList(nums[0]));
        }
        return help(nums);
    }

    public List<List<Integer>> help(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==2){
            return Arrays.asList(Arrays.asList(nums[0],nums[1]),Arrays.asList(nums[1],nums[0]));
        }
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> integers : help(remove(nums,i))) {
                List<Integer> eles=new ArrayList<>();
                eles.add(nums[i]);
                eles.addAll(integers);
                temp.add(eles);
            }
            res.addAll(temp);
        }
        return res;
    }

    public int[] remove(int[] nums,int index){
        int[] res = new int[nums.length-1];
        int j=0;
        for (int i = 0; i < nums.length; i++) {
            if (i!=index){
                res[j++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1,2,3,4,5}));
    }
}
