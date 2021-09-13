package leetcode;

/**
 *
 * 冗余连接
 * https://leetcode-cn.com/problems/redundant-connection/
 * @author jzt
 * @version 1.0
 * @date 2021-02-07 09:41
 **/
public class FindRedundantConnection {
    private int[] parent;
    public void init(int len){
        parent = new int[len];
        for (int index=0;index<len;index++){
            parent[index] = -1;
        }
    }
    public int find(int u){
        return parent[u]==-1?u:find(parent[u]);
    }
    public boolean union(int u,int v){
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot!=vRoot){
           parent[uRoot] = vRoot;
           return true;
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int [] res = new int[2];
        int len = edges.length;
        init(len+1);
        for (int index=0;index<len;index++){
            int u = edges[index][0];
            int v = edges[index][1];
            if (!union(u,v)){
                res = edges[index];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new FindRedundantConnection().findRedundantConnection(new int[][]{
                {1,2},{1,3},{2,3}
        });
    }
}
