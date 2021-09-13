package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 打家劫舍
 *
 * https://leetcode-cn.com/problems/house-robber/
 **/
public class Rob {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int preAndPre   = nums[0];
        int pre = Math.max(nums[0],nums[1]);
        int max = Math.max(pre,preAndPre);
        for (int index =2;index<nums.length;index++){
            max = Math.max(preAndPre+nums[index],pre);
            preAndPre = pre;
            pre = max;
        }
        return max;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("5");
        list1.add("6");
        list1.add("7");
        list1.add("8");

        List<String> list2 = new ArrayList<String>();
        list2.add("2");
        list2.add("7");
//        list2.add("10");

        //交集
        List<String> collect1 = list1.stream().filter(num -> list2.contains(num))
                .collect(Collectors.toList());
        System.out.println("交集");
        collect1.stream().forEach(System.out::println);

        //差集 list1-list2
        List<String> collect2 = list1.stream().filter(num -> !list2.contains(num))
                .collect(Collectors.toList());
        System.out.println("差集list1-list2");
        collect2.stream().forEach(System.out::println);

        //差集list2-list1
        List<String> collect3 = list2.stream().filter(num -> !list1.contains(num))
                .collect(Collectors.toList());
        System.out.println("差集list2-list1");
        collect3.stream().forEach(System.out::println);
    }
}
