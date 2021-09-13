package leetcode;

import java.util.LinkedList;
import leetcode.data.TreeNode;
/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoh1zg/
 * @author jzt
 * @version 1.0
 * @date 2021-03-16 20:16
 **/
public class MaxDepth {
    private Integer depth = 1;

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int arithmetic = 0;
            for (int index=0;index<len;index++){
                TreeNode first = queue.remove();
                if (first.left!=null){
                    if (arithmetic==0){
                        arithmetic+=1;
                    }
                    queue.offer(first.left);
                }
                if (first.right!=null){
                    if (arithmetic==0){
                        arithmetic+=1;
                    }
                    queue.offer(first.right);
                }
            }
            depth+=arithmetic;
        }
        return depth;
    }


    public int maxDepthI(TreeNode root) {
        if (root==null){
            return 0;
        }
        int lMaxDepth = maxDepth(root.left);
        int rMaxDepth = maxDepth(root.right);
        return Math.max(lMaxDepth,rMaxDepth)+1;
    }
}
