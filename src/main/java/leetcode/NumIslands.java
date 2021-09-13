package leetcode;

/**
 * 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/
 * @author jzt
 * @version 1.0
 * @date 2021-02-08 11:29
 **/
public class NumIslands {
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
    public int connectedComponent(){
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

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //水的数量
        int empty = 0;
        int nx = grid.length;
        int ny = grid[0].length;
        init(nx*ny);
        for (int x=0;x<nx;x++){
            for (int y=0;y<ny;y++){
                if (grid[x][y]=='0'){
                    empty++;
                }
                if (grid[x][y] == '1') {
                    //r+1<nr 为了做防止下标溢出
                    //c + 1 < ny 同理
                    if (x + 1 < nx && grid[x+1][y] == '1') {
                        union(x * ny + y, (x+1) * ny + y);
                    }
                    if (y + 1 < ny && grid[x][y+1] == '1') {
                        union(x * ny + y, x * ny + y + 1);
                    }
                }

            }
        }
        //连通分量-水地的数量就是陆地等数量
        return connectedComponent()-empty;
    }

    public static void main(String[] args) {
        new NumIslands().numIslands(new char[][]{
                {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}   
        });
    }
}
