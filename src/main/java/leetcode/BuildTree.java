package leetcode;

import java.util.HashMap;
import leetcode.data.TreeNode;
/**
 * 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * @author jzt
 * @version 1.0
 * @date 2021-03-23 10:52
 **/
public class BuildTree {
    /**
     * key: 中序遍历的值
     * value: 下标
     **/
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    /**
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param inorder 中序遍历
     * @param postorder 后序遍历
     *
     **/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) {
            return null;
        }

        int root = post[pe];
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }


    public TreeNode buildTreeII(int il,int ir,int pl,int pr){
        if (ir<il||pr<pl){
            return null;
        }
        TreeNode root = new TreeNode();
        //root 的值是 后序遍历的最后一个节点
        root.val = post[pr];
        //根节点的下标
        int rootIndex = memo.get(post[pr]);
        //右子树的长度
        int len = ir- rootIndex;
        root.left = buildTreeII(il,rootIndex-1,pl,pr-len-1);
        root.right = buildTreeII(rootIndex+1,ir,pr-len,pr-1);
        return root;
    }
}
