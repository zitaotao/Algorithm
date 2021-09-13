package leetcode;

import leetcode.data.Node;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 填充每个节点的下一个右侧节点指针
 * @author jzt
 * @version 1.0
 * @date 2021-03-25 09:52
 **/
public class Connect {

    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            //广度遍历
            //连接右节点
            for (int index=0;index<len;index++) {
                Node first = queue.remove();
                try {
                    if (index<len-1){
                        first.next = queue.getFirst();
                    }
                }catch (Exception e){
                  //
                }
                if (first.left!=null){
                    queue.offer(first.left);
                }
                if (first.right!=null){
                    queue.offer(first.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right=g;
        new Connect().connect(a);
    }

}
