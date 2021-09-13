package leetcode;

/**
 * 请描述类的业务用途
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/21 8:04 下午
 **/
public class Xxx {
    private int[] parent;

    public int find(int e){
        if (parent[e]==e){
            return e;
        }
        return find(parent[e]);
    }

    public void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot){
           return;
        }
        parent[xRoot] = yRoot;
    }
    boolean check = true;

    public int  check(int y,int x){
        if (parent[y]==y){
            return y;
        }
        int yRoot = check(parent[y],x);
        if (yRoot ==x){
            check = false;
        }
        return yRoot;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        parent = new int[numCourses];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] prerequisite : prerequisites) {
            check(prerequisite[1],prerequisite[0]);
            if (!check){
                return false;
            }
            union(prerequisite[0], prerequisite[1]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Xxx().canFinish(4,new int[][]{{1,0},{2,1},{3,2},{0,1}}));
    }
}
