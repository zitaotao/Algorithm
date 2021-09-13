package leetcode.data;

/**
 * 图
 *
 * @author jzt
 * @version 1.0
 * @date 2021-02-19 11:37
 **/
public class Edge {
    /**
     * 点 x
     **/
    public int x;
    /**
     * 点 y
     **/
    public int y;
    /**
     * 权值
     **/
    private int weight;

    public Edge(){}

    public Edge(int x,int y,int weight){
        this.x=x;
        this.y=y;
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
