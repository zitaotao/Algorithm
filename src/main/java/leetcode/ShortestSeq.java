package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 最短超串
 * https://leetcode-cn.com/problems/shortest-supersequence-lcci/
 * 滑动窗口
 * @Author user
 * @Date 2020-12-18 10:38
 * @Version 1.0
 **/
public class ShortestSeq {

    public static int[] shortestSeq(int[] big, int[] small) {

        Map<Integer,Integer> smallMap = new HashMap<>();
        Map<Integer,Integer> copySmallMap= new HashMap<>();
        Map<Integer,Integer> indexMap= new HashMap<>();
        for (int index = 0;index<small.length; index++) {
            smallMap.put(small[index],index);
            copySmallMap.put(small[index],index);
        }
        Map<Integer,int[]> dp = new HashMap<>();
        List<String> bigList = new ArrayList<>();
        for (int i = 0;i<big.length;i++){
            bigList.add(big[i]+"");
            if (big.length-i<small.length){
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            Boolean flag  = false;
            smallMap = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) copySmallMap).clone();
            for (int index = i;index<big.length; index++) {
                indexMap.put(index,big[index]);
                if (flag){
                    temp.add(index);
                }
                if (smallMap.containsKey(big[index])){
                    if (!flag){
                        temp.add(index);
                    }
                    smallMap.remove(big[index]);
                    flag = true;
                    if (smallMap.size()==0){
                        smallMap = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) copySmallMap).clone();
                        int[] oneRes = new int[]{temp.get(0),temp.get(temp.size()-1)};
                        if (!dp.containsKey(temp.size())){
                            dp.put(temp.size(),oneRes);
                        }
                        temp = new ArrayList<>();
                        flag = false;
                    }
                }
            }
        }

        if (dp.isEmpty()){
            return new int[]{};
        }
        int key = dp.keySet().stream().sorted().collect(Collectors.toList()).get(0);
        int start = dp.get(key)[0];
        int end = dp.get(key)[1];
        String strBig = String.join(",",bigList.subList(start,end+1<bigList.size()?end+1:end));
        for (int index = dp.get(key)[0];index<dp.get(key)[1];index++){
            strBig = strBig.substring((big[index]+" ").length());
            if (strBig.contains(big[index]+"")||!copySmallMap.containsKey(big[index])){
                start = index+1;
            }else {
                break;
            }
        }
        dp.get(key)[0] = start;
        return dp.get(key);
    }

    public static void main(String[] args) {
        shortestSeq(new int[]{364399, 334850, 233186, 198148, 72077, 906245, 344896, 633113, 936568, 637003},new int[]{334850, 344896, 637003, 906245, 364399, 198148});
        System.out.println();
    }
}
