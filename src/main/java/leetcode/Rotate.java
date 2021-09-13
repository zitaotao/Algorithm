package leetcode;

/**
 * 旋转矩阵
 * https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * @author jzt
 * @version 1.0
 * @date 2021-03-31 09:45
 **/
public class Rotate {


    /**
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     **/
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0) {return;}
        int left = 0,top = 0,right = matrix[0].length-1,bottom = matrix.length-1;
        int temp;
        //因为是单位矩阵，所以不会出现线旋转的情况
        while (left<right){
            //注意i，我们想要它有两种意义，一个是表示组号一个是表示加上left的坐标
            for(int i = left;i<right;i++){
                //上matrix[top][i],坐标
                //右matrix[i][right],坐标
                //下matrix[bottom][right-i]，组号
                //左matrix[bottom-i][left]，组号
                //上->右->下->左->上
                //记住右
                temp = matrix[i][right];
                //上->右
                matrix[i][right] = matrix[top][i];
                //左->上
                matrix[top][i] = matrix[bottom-(i-left)][left];
                //下->左
                matrix[bottom-(i-left)][left] = matrix[bottom][right-(i-left)];
                //右->下
                matrix[bottom][right-(i-left)] = temp;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
    }


    public void rotateII(int[][] matrix){
        if (matrix==null||matrix.length==0){
            return;
        }
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        while (l<r){
            for(int i = l;i<r;i++){
                //逆指针对矩阵进行旋转  这里的逆时针是指操作的顺序而不是结果的顺序
                int temp = matrix[i][r];
            }
            l++;
            r--;
            t++;
            b--;
        }
    }

}
