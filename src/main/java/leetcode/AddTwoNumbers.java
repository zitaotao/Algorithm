package leetcode;

import leetcode.data.ListNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *  两数相加
 * @author jzt
 * @version 1.0
 * @date 2021/4/30 1:40 下午
 **/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1LenRoot = l1;
        int l1len = 1;
        while (l1LenRoot.next!=null){
            l1LenRoot = l1LenRoot.next;
            l1len++;
        }
        ListNode l2LenRoot = l2;
        int l2len = 1;
        while (l2LenRoot.next!=null){
            l2LenRoot = l2LenRoot.next;
            l2len++;
        }
        int len = Math.max(l1len,l2len);
        LinkedList<Integer> queue = new LinkedList();
        queue.offer(l1.val);
        queue.offer(l2.val);
        ListNode root = new ListNode();
        ListNode current = root;
        for (int i=0;i<len;i++){
            int f = 0;
            int s =0;
            if (!queue.isEmpty()){
                f = queue.remove();
            }
            if (!queue.isEmpty()){
               s = queue.remove();
            }
            ListNode next = new ListNode();
            next.val = (f+s+current.val)/10;
            current.next = next;
            current.val = (f+s+current.val)%10;
            if (i==len-1&&next.val == 0){
                current.next = null;
            }
            current = next;
            if (l1.next!=null){
                queue.offer(l1.next.val);
                l1 = l1.next;
            }
            if (l2.next!=null){
                queue.offer(l2.next.val);
                l2 = l2.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode x = new ListNode(9);
        ListNode xx = new ListNode(9);
        ListNode xxx = new ListNode(9);
        ListNode xxxx = new ListNode(9);
        a.next = b;
        b.next = c;
        c.next =x;
        x.next=xx;
        xx.next=xxx;
        xxx.next=xxxx;
        ListNode d = new ListNode(9);
        ListNode e = new ListNode(9);
        ListNode f = new ListNode(9);
        ListNode fx = new ListNode(9);
        d.next = e;
        e.next= f;
        f.next = fx;
        new AddTwoNumbers().addTwoNumbers(a,d);
    }
}
