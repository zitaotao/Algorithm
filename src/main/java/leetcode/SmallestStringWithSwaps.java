package leetcode;

import disjoint_set.DisjointSet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 交换字符串中的元素
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
 * @author jzt
 * @version 1.0
 * @date 2021-02-18 20:46
 **/
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs==null||pairs.isEmpty()){
            return s;
        }
        int len = s.length();

        DisjointSet disjointSet =new DisjointSet();
        //初始化并查集
        disjointSet.init(len);
        //构造并查集
        pairs.forEach(pair->{
           disjointSet.union(pair.get(0),pair.get(1));
        });
        StringBuilder res = new StringBuilder();
        // key：连通分量的代表元，value：同一个连通分量的字符集合（保存在一个优先队列中）
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for(int index=0;index<len;index++){
            int root = disjointSet.find(index);
            hashMap.computeIfAbsent(root, key -> new PriorityQueue<>()).offer(s.charAt(index));
        }
        //连接字符串
        for (int index = 0; index < len; index++) {
            int root = disjointSet.find(index);
            res.append(hashMap.get(root).poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new SmallestStringWithSwaps().smallestStringWithSwaps("dcab",Arrays.asList(Arrays.asList(0,3),Arrays.asList(1,2)));
    }
}
