package leetcode;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 98. 验证二叉搜索树
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/1 3:11 下午
 **/
public class IsValidBST {
    List<Integer> eles = new ArrayList<>();

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 假设一个二叉搜索树具有如下特征：
     * <p>
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     **/
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        help(root);
        if(eles.size()==1){
            return true;
        }
        for (int i=1; i<eles.size() ;i++) {
            if (eles.get(i-1)>=eles.get(i)){
                return false;
            }
        }
        return true;
    }


    public void help(TreeNode root) {
        //左
        if (root.left != null) {
            help(root.left);
        }
        eles.add(root.val);
        //右
        if (root.right != null) {
            help(root.right);
        }
    }

}
