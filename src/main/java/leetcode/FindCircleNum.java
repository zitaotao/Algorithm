package leetcode;

/**
 *
 * 省份数量
 *
 * https://leetcode-cn.com/problems/number-of-provinces/
 * @author jzt
 * @version 1.0
 * @date 2021-02-07 14:17
 **/
public class FindCircleNum {
    private int[] parent;
    public void init(int len){
        parent = new int[len];
        for (int index=0;index<len;index++){
            parent[index] = -1;
        }
    }
    public int find(int connect){
        return parent[connect]==-1?connect:find(parent[connect]);
    }
    public void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot!=bRoot){
            parent[aRoot] = bRoot;
        }
    }

    public int connectedComponent(){
        int count = 0;
        for (int index =0;index<parent.length;index++) {
            if (parent[index]==-1){
                count++;
            }
        }
        return count;
    }

    public int findCircleNum(int[][] isConnected) {
        init(isConnected.length);
        for (int i=0;i<isConnected.length;i++){
            for (int j=0;j<isConnected[i].length;j++){
                if (isConnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        return connectedComponent();
    }

    public static void main(String[] args) {
        System.out.println(new FindCircleNum().findCircleNum(new int[][]{
                {1,0,0},{0,1,0},{0,0,1}
        }));
    }
}
