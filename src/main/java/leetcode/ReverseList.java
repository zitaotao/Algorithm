package leetcode;

import leetcode.data.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/
 *
 * 反转链表
 * @author user
 * */

public class ReverseList {

    /**
     * 递归
     **/
    public static ListNode reverseList(ListNode pre, ListNode head){
        if (head == null){
            return pre;
        }
        if (head.next==null){
            head.next = pre;
            return head;
        }
        ListNode next = head.next;
        ListNode next_next = head.next.next;
        next.next = head;
        head.next=pre;
        return reverseList(next,next_next);
    }

    /**
     * 迭代
     **/
    public static ListNode reverseListV2(ListNode pre, ListNode head){
        while (head != null) {
            ListNode next= head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        reverseListV2(null,a);
    }
}
