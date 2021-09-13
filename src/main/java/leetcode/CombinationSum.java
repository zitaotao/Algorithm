package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author jzt
 * @version 1.0
 * @date 2021/5/7 3:17-33 下午
 **/
public class CombinationSum {

    private Map<String,String> cache = new HashMap<>();
    private int cacheTarget = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.cacheTarget = target;
        Arrays.sort(candidates);
        List<Integer> candidatesList = new ArrayList<>();
        for (int candidate : candidates) {
            candidatesList.add(candidate);
        }
        List<List<Integer>> res = new ArrayList<>();
        if (candidatesList.contains(target)) {
            List<Integer> ele = new ArrayList<>();
            ele.add(target);
            res.add(ele);
        }
        List<List<Integer>> sub = help(candidatesList,target);
        if (!sub.isEmpty()){
            res.addAll(sub);
        }
        return res;
    }

    public List<List<Integer>> help(List<Integer> candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.contains(target)&&this.cacheTarget != target) {
            List<Integer> ele = new ArrayList<>();
            ele.add(target);
            res.add(ele);
            return res;
        }
        if (candidates.get(0)>target){
            return new ArrayList<>();
        }
        for (int i=0;i<candidates.size();i++){
            int currentEle= candidates.get(i);
            List<List<Integer>> subRes = help(candidates,target-currentEle);
            if (!subRes.isEmpty()){
                for (List<Integer> subEles : subRes) {
                    subEles.add(currentEle);
                    subEles =  subEles.stream().sorted().collect(Collectors.toList());
                    StringBuilder key = new StringBuilder();
                    for (Integer subEle : subEles) {
                        key.append(subEle).append(",");
                    }
                    if (cacheTarget!=target||!cache.containsKey(key.toString())){
                        cache.put(key.toString(),key.toString());
                        res.add(subEles);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{1,2},3);
    }
}
