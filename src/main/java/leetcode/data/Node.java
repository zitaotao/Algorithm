package leetcode.data;

/**
 *
 *
 * @author jzt
 * @version 1.0
 * @date 2021-03-25 09:51
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
