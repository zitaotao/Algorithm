package leetcode;

import java.util.*;

import leetcode.data.TreeNode;
/**
 * 二叉树的层序遍历
 *
 * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xefh1i/
 * @author jzt
 * @version 1.0
 * @date 2021-03-11 19:15
 **/
public class LevelOrder {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> eles = new ArrayList<>();
            for (int index=0;index<len;index++){
                TreeNode first = queue.remove();
                eles.add(first.val);
                if (first.left!=null){
                    queue.offer(first.left);
                }
                if (first.right!=null){
                    queue.offer(first.right);
                }
            }
            res.add(eles);
        }
        return res;
    }


}
