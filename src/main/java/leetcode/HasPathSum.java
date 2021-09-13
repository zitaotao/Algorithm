package leetcode;

import leetcode.data.TreeNode;

import java.util.*;

/**
 * 路径总和
 * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo566j/
 * @author jzt
 * @version 1.0
 * @date 2021-03-20 15:44
 **/
public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);
        a.left = b;
        a.right = null;
        b.left = c;
        b.right = null;
        c.left = d;
        c.right=null;
        d.left = e;
        new HasPathSum().hasPathSum(a,6);
    }
}
