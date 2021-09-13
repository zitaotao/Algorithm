package leetcode;

import java.util.Arrays;

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/leetbook/read/binary-search/xe3pwj/
 * @author jzt
 * @version 1.0
 * @date 2021-03-09 16:03
 **/
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = Math.max(nums1.length,nums2.length),index_I = 0,index_II = 0,resIndex = 0;
        int[] res = new int[len];
        while (index_I<nums1.length && index_II<nums2.length){
            if (nums1[index_I]==nums2[index_II]){
                res[resIndex++] = nums1[index_I];
                index_II++;
                index_I++;
                continue;
            }
            if (nums1[index_I]>nums2[index_II]){
                index_II++;
                continue;
            }
            if (nums2[index_II]>nums1[index_I]){
                index_I++;
            }
        }
        return Arrays.copyOf(res,resIndex);
    }

    public static void main(String[] args) {
        new Intersect().intersect(new int[]{1,2},new int[]{1,1});
    }
}
