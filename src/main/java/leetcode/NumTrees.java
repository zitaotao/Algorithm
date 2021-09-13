package leetcode;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 96. 不同的二叉搜索树
 * @author jzt
 * @version 1.0
 * @date 2021/7/1 11:28 上午
 **/
public class NumTrees {
    int n1 = 1;
    int n2 = 2;
    int n3 = 5;
    /**
     * 给你一个整数 n
     * 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
     **/
    public int numTrees(int n) {
        if (n==1){
            return n1;
        }
        if (n==2){
            return n2;
        }
        if (n==3){
            return n3;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i==1){
                res = res+numTrees(n-1);
            }else
            if (i==n){
                res = res+numTrees(n-1);
            }else {
                int l = i-1;
                int r = n-i;
                if (l>1&&r<=1){
                    res = res+numTrees(l);
                }else if (r>1&&l<=1){
                    res = res+numTrees(r);
                }else {
                    res = res+numTrees(r)*numTrees(l);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(4));
    }
}
