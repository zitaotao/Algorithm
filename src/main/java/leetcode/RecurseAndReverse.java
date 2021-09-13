package leetcode;

import leetcode.data.ListNode;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode/
 * 反转链表 II
 * @Author user
 * @Date 2020-12-27 11:43
 * @Version 1.0
 **/
public class RecurseAndReverse {
    public static int index = 0;
    public static ListNode mNode ;
    public static ListNode mNodePre ;
    public static ListNode nNodeNext ;
    public static ListNode nNode ;
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = xx(head,m,n);
        if (m==1){
            return nNode;
        }
        return head;
    }

    private static ListNode  xx(ListNode head, int m, int n){
        index++;

        if ((index==(m-1)||m==1)&&(mNode==null)){
            mNode = head.next;
            mNodePre = head;
        }

        if (index==n-1){
            nNode = head;
            nNodeNext = head.next;
        }
        if (head == null||head.next==null){
            return head;
        }

        if (index>=m&&index<n){
            ListNode next = xx(head.next,m,n);
            next.next = head;
            head.next = null;

        }
        while (index<m){
            head = head.next;
            xx(head,m,n);
        }
        return head;
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
//        System.out.println(reverseBetween(a,2,3));
    }
}
