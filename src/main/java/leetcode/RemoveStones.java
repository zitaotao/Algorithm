package leetcode;

/**
 *
 * 移除最多的同行或同列石头
 *
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * @author jzt
 * @version 1.0
 * @date 2021-02-07 14:50
 **/
public class RemoveStones {

    private int[] parent;

    public int find(int x){
        return parent[x]==-1?x:find(parent[x]);
    }

    public void init(int len){
        parent = new int[len];
        for (int index=0;index<len;index++){
            parent[index] = -1;
        }
    }

    /**
     * 获取连通分量
     **/
    public int connectedComponent(int max){
        int count = 0;
        for (int index=0;index<parent.length;index++) {
            if (parent[index] == -1) {
                count++;
            }
        }
        return count;
    }

    public void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot!=yRoot){
            parent[yRoot] = xRoot;
        }
    }
    public int removeStones(int[][] stones) {
        init(stones.length);
        int max = 0;
        for (int i=0;i<stones.length;i++){
            for (int j=i+1;j<stones.length;j++){
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i,j);
                }
            }
        }
        return stones.length-connectedComponent(max);
    }

    public static void main(String[] args) {
//        [0,0],[0,1],[1,0],[1,2],[2,1],[2,2]
        System.out.println(new RemoveStones().removeStones(new int[][]{
                {0,0},{0,1}
        }));
    }
}
