package leetcode;
import leetcode.data.TreeNode;
/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
 * @author jzt
 * @version 1.0
 * @date 2021-03-29 16:54
 **/

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null||root == p || root ==q){
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if (l==null){
            return r;
        }
        if (r==null){
            return l;
        }
        return root;
    }

}
