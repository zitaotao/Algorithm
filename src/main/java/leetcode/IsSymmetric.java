package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import leetcode.data.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoxzgv/
 * @author jzt
 * @version 1.0
 * @date 2021-03-17 20:06
 **/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> levelNode = new ArrayList<>();
            for (int index=0;index<len;index++){
                TreeNode first = queue.remove();
                if (first.left!=null){
                    levelNode.add(first.left.val);
                    queue.offer(first.left);
                }else {
                    levelNode.add(null);
                }

                if (first.right!=null){
                    levelNode.add(first.right.val);
                    queue.offer(first.right);
                }else {
                    levelNode.add(null);
                }
            }
            //双指针遍历
            int l = 0,r = levelNode.size()-1;
            for(int index = 0;index<levelNode.size();index+=2){
                Integer lVal = levelNode.get(l);
                Integer rVal = levelNode.get(r);
                if (lVal==null&&rVal==null){
                    l++;
                    r--;
                    continue;
                }
                if ((lVal==null&&rVal!=null)||(rVal==null&&lVal!=null)||(!lVal.equals(rVal))){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }


}
