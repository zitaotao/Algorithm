package leetcode;

import leetcode.data.ListNode;

/**
 * 移除链表元素
 * @Author user
 * @Date 2021-01-04 19:44
 * @Version 1.0
 **/
public class RemoveElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }

        while (head.val==val){
             head = head.next;
             if (head==null){
                 return null;
             }
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null){
            while (fast!=null&&fast.val == val){
                fast = fast.next;
            }
            slow.next = fast;
            slow = fast;
            if (fast==null){
                return head;
            }
            fast =fast.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        removeElements(a,2);
    }

}
