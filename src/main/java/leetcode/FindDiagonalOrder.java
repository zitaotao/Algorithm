package leetcode;

import java.util.List;

/**
 * 对角线遍历
 * https://leetcode-cn.com/leetbook/read/array-and-string/cuxq3/
 * @author jzt
 * @version 1.0
 * @date 2021-04-06 16:12
 **/
public class FindDiagonalOrder {
    /**
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     **/
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[m * n];

        int k = 0;
        //遍历的方向
        boolean bXFlag = true;
        for (int i = 0; i < m + n; i++){
            int pm = bXFlag ? m : n;
            int pn = bXFlag ? n : m;
            int x = (i < pm) ? i : pm - 1;
            int y = i-x;
            while (x>=0&&y<pn){
                nums[k++] = bXFlag ? matrix[x][y] : matrix[y][x];
                x--;
                y++;
            }
            bXFlag = !bXFlag;
        }
        return nums;
    }

    public static void main(String[] args) {
        new FindDiagonalOrder().findDiagonalOrder(new int[][]{
                {1,2,3},{5,6,7},{9,10,11},{13,14,15}
        });
    }
}
