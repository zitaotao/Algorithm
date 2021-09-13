package leetcode;

import disjoint_set.DisjointSet;
import leetcode.data.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 最小体力消耗路径
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 * @author jzt
 * @version 1.0
 * @date 2021-02-08 16:11
 **/
public class MinimumEffortPath {

    public int minimumEffortPath(int[][] heights) {
        int xLen = heights.length;
        int yLen = heights[0].length;
        if (xLen == yLen&&xLen==1){
            return 0;
        }
        DisjointSet disjointSet = new DisjointSet();
        //初始化并查集
        disjointSet.init(xLen*yLen);
        //图边的集合
        List<Edge> edgeList = new ArrayList<>();
        for (int x=0;x<xLen;x++){
            for (int y=0;y<yLen;y++){
                //右
                if (y<yLen-1){
                    Edge edge = new Edge(x*yLen+y,x*yLen+y+1,Math.abs(heights[x][y]-heights[x][y+1]));
                    edgeList.add(edge);
                }
                //下
                if (x<xLen-1){
                    Edge edge = new Edge(x*yLen+y,(x+1)*yLen+y,Math.abs(heights[x][y]-heights[x+1][y]));
                    edgeList.add(edge);
                }

            }
        }
        edgeList.sort(Comparator.comparing(Edge::getWeight));
        for (Edge edge : edgeList) {
            disjointSet.union(edge.x,edge.y);
            if (disjointSet.connected(0,xLen*yLen-1)){
                return edge.getWeight();
            }
        }
        return Integer.MIN_VALUE;
    }



    public static void main(String[] args) {
        new MinimumEffortPath().minimumEffortPath(new int[][]{
                {1,2,2},{3,8,2},{5,3,5}
        });
    }
}

