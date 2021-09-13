package leetcode;

/**
 * 连接所有点的最小费用
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 * @author jzt
 * @version 1.0
 * @date 2021-02-04 15:46
 **/
public class MinCostConnectPoints {

//    /**
//     * 最小生成树之Kruskal算法
//     * 思路：依据 Kruskal算法来选取曼哈顿距离 最小的点集
//     **/
//    public int minCostConnectPoints(int[][] points) {
//
//    }

    private int[] getMinDistance(int[] point,int index,int[][] points){
        int len = 0;
        int targetIndex = 0;
        int []res =new int[2];
        int x = point[0];
        int y = point[1];
        for (int i=0;i<points.length;i++){
            if (i!=index){
                if (Math.abs(x-points[i][0])+Math.abs(y-points[i][1])<len){
                    len = Math.abs(x-points[i][0])+Math.abs(y-points[i][1]);
                    targetIndex = i;
                }

            }
        }
        res[0]=len;
        res[1]= targetIndex;
        return res;
    }
}
