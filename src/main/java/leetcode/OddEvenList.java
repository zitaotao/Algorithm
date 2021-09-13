package leetcode;

import leetcode.data.ListNode;

/**
 * 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * https://leetcode-cn.com/leetbook/read/linked-list/fe0kj/
 * @author jzt
 * @version 1.0
 * @date 2021-01-17 10:58
 **/
public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode oddHead = head.next;
        ListNode slowPre = null;
        //true为偶数，false奇数
        boolean isEven = false;
        while (fast!=null){
            if (!isEven){
                slowPre = slow;
            }
            isEven =!isEven;
            slow.next = fast.next;
            slow = fast;
            fast = fast.next;
        }
        if (!isEven){
            slow.next = oddHead;
        }
        if (isEven){
            if (oddHead == slow){
                head.next =oddHead;
            }
            if (oddHead != slow){
                slowPre.next = oddHead;
            }
        }
        return head;
    }
}
