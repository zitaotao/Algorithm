package leetcode;

import java.util.*;

public class Merge {
    /**
     * 合并两个有序数组
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * @author jzt
     * @version 1.0
     * @date 2021-02-28 15:39
     **/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1,p2=n-1,p3=m+n-1;
        while(p2 >= 0){
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p3--] = nums1[p1--];
            } else {
                nums1[p3--] = nums2[p2--];
            }
        }
    }


    /**
     * 合并区间
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     **/
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int l = intervals[0][0],r = intervals[0][1],i=0;
        for (int index=1;index<intervals.length;index++) {
            if (intervals[index][1]<l){
                res.add(new int[]{l,r}) ;
                l = intervals[index][0];
                r = intervals[index][1];
                continue;
            }
            if (l>=intervals[index][0]){
                l = intervals[index][0];
            }
            if (r>=intervals[index][0]&&r<=intervals[index][1]){
                r = intervals[index][1];
                continue;
            }
            if (r<intervals[index][0]){
                res.add(new int[]{l,r}) ;
                l = intervals[index][0];
                r = intervals[index][1];
            }
        }
        res.add(new int[]{l,r}) ;
        int [][] xx = new int[res.size()][2];
        return res.toArray(xx);
    }




    public static void main(String[] args) {

        new Merge().merge(new int[][]{
                {1,4},{1,4}
        });
    }
}
