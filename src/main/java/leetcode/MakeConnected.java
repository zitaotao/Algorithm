package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 连通网络的操作次数
 *
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * @author jzt
 * @version 1.0
 * @date 2021-02-07 13:45
 **/
public class MakeConnected {
    private int[] parent;

    public int find(int connection){
        return parent[connection]==-1?connection:find(parent[connection]);
    }

    public void init(int len){
        parent = new int[len];
        for (int index=0;index<len;index++){
            parent[index] = -1;
        }
    }

    private int connectedComponent(){
        int count;
        count = 0;
        for (int index =0;index<parent.length;index++) {
            if (parent[index]==-1){
                count++;
            }
        }
        return count-1;
    }
    public void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot!=yRoot){
            parent[yRoot] = xRoot;
        }
    }
    /**
     * n:机器的数量
     **/
    public int makeConnected(int n, int[][] connections) {
        if (connections.length<n-1){
            return -1;
        }
        init(n);
        for (int index=0;index<connections.length;index++){
            union(connections[index][0],connections[index][1]);
        }
        return connectedComponent();
    }

    public static void main(String[] args) {
        System.out.println(new MakeConnected().makeConnected(6,new int[][]{
                {0,1},{0,2},{0,3},{1,2},{1,3}
        }));
    }
}
