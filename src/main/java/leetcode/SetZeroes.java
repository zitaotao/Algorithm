package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 零矩阵
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * @author jzt
 * @version 1.0
 * @date 2021-04-06 15:32
 **/
public class SetZeroes {
    /**
     * 零矩阵
     **/
    public void setZeroes(int[][] matrix) {
        if (matrix==null||matrix[0].length==0){
            return;
        }
        Map<String,Integer> dirty = new HashMap<>();
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[i].length;j++){
                if (dirty.containsKey(i+"_"+j)){
                    continue;
                }
                int ele = matrix[i][j];
                if (ele==0){
                    //行
                    for(int j1 = 0;j1<matrix[i].length;j1++){
                        if (matrix[i][j1]!=0){
                            matrix[i][j1] = 0;
                            dirty.put(i+"_"+j1,1);
                        }
                    }
                    //列
                    for(int i1 = 0;i1<matrix.length;i1++){
                        if (matrix[i1][j]!=0){
                            matrix[i1][j] = 0;
                            dirty.put(i1+"_"+j,1);
                        }

                    }
                }
            }
        }
    }
}
