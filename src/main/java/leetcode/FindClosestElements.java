package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到 K 个最接近的元素
 * https://leetcode-cn.com/leetbook/read/binary-search/xeve4m/
 * @author jzt
 * @version 1.0
 * @date 2021-03-06 15:33
 **/
public class FindClosestElements {
    /**
     * 解题思路
     * 1.处理特例
     * 2.二分查找，找到距离x最近的元素下标Index（因为题目要求返回距离x最近的K个元素，所以Index附近的K个元素一定是满足条件的解）
     * 3.滑动窗口寻找结果集合
     **/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //特例 arr 为空 或者 len == 0 直接返回
        if (arr==null||arr.length==0){
            return new ArrayList<>();
        }
        //特例 K 包含arr所有的元素直接返回
        if (k==arr.length){
            List<Integer> res = new ArrayList<>();
            for (int i : arr) {
                res.add(i);
            }
            return res;
        }
        //二分查找获取距离x最近的元素下标
        int index = search(arr,x);
        int l = index,r = index,len = arr.length;
        List<Integer> res = new ArrayList<>(len);
        //利用滑动窗口，获取结果集
        //在窗口滑动的时候，先操作左窗口，因为题目要求
        //整数 a 比整数 b 更接近 x 需要满足：
        //|a - x| < |b - x| 或者
        //|a - x| == |b - x| 且 a < b
        for (int i = 0;i<k;){
            if (l == r){
                res.add(arr[l]);
                l--;
                r++;
                i++;
                continue;
            }
            if (l>-1){
                if (Math.abs(arr[l]-x)<= (r<len?Math.abs(arr[r]-x):Integer.MAX_VALUE)){
                    res.add(arr[l]);
                    l--;
                    i++;
                }
            }
            if (res.size()==k){
                //题目要求返回一个升序的结果，所以直接利用arr有序的条件，得出结果
                index = 0;
                for (l=l+1;l<r;l++){
                    res.set(index,arr[l]);
                    index++;
                }
                return res;
            }
            if (r<len){
                if (Math.abs(arr[r]-x)<(l>-1?Math.abs(arr[l]-x):Integer.MAX_VALUE)){
                    res.add(arr[r]);
                    r++;
                    i++;
                }

            }
        }
        //题目要求返回一个升序的结果，所以直接利用arr有序的条件，得出结果
        index = 0;
        for (l=l+1;l<r;l++){
            res.set(index,arr[l]);
            index++;
        }
        return res;
    }

    /**
     * 二分查找，需要距离target最近的元素下标
     **/
    public int search(int[] arr, int target){
        if (arr[0]>target){
            return 0;
        }
        if (arr[arr.length-1]<target){
            return arr.length-1;
        }
        int l = 0,r = arr.length-1,res = 0;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (target == arr[mid]){
                return mid;
            }
            if (target > arr[mid]){
                l = mid + 1;
            }
            if (target < arr[mid]){
                r = mid - 1;
            }
            res = Math.abs(arr[res]-target)>Math.abs(arr[mid]-target)?mid:res;

        }
        return res;
    }

    public static void main(String[] args) {
         new FindClosestElements().findClosestElements(new int[]{1,2,3,3,6,6,7,7,9,9},8,8);
    }
}
