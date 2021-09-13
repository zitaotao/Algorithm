package leetcode;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 114. 二叉树展开为链表
 * @author jzt
 * @version 1.0
 * @date 2021/7/1 5:20 下午
 **/
public class Flatten {
    List<TreeNode> eles = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        help(root);
        eles.add(null);
        for (int i = 1; i < eles.size();i++ ) {
            eles.get(i-1).left=null;
            eles.get(i-1).right = eles.get(i);
        }

    }
    public void help(TreeNode root) {
        eles.add(root);
        //左
        if (root.left != null) {
            help(root.left);
        }
        //右
        if (root.right != null) {
            help(root.right);
        }
    }
}
