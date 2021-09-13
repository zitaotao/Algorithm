package leetcode;

import leetcode.data.ListNode;

/**
 * https://leetcode-cn.com/problems/sort-list/
 * 148. 排序链表
 *
 * @author jzt
 * @version 1.0
 * @date 2021/7/2 2:38 下午
 **/
public class SortList {
    int len = 1;

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 进阶：
     * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * <p>
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * <p>
     * 输入：head = []
     * 输出：[]
     **/
    public ListNode sortList(ListNode head) {
        ListNode lenHead = head;
        while (lenHead.next != null) {
            len++;
            lenHead = lenHead.next;
        }
        return help(head, len);
    }

    public ListNode help(ListNode head, int len) {
        if (len <= 2) {
            if (head==null){
                return head;
            }
            return helpSort(head, head.next);
        }
        ListNode lHead = head;
        ListNode l = help(lHead, len / 2);
        int i = 0;
        ListNode rHead = head;
        while (i != len - len / 2) {
            i++;
            rHead = rHead.next;
        }
        ListNode r = help(rHead, len - len / 2);
        return helpMerge(l, r);
    }

    public ListNode helpSort(ListNode l, ListNode r) {
        if (r == null) {
            return new ListNode(l.val);
        }
        ListNode min = new ListNode(Math.min(l.val, r.val));
        ListNode max = new ListNode(Math.max(l.val, r.val));
        min.next = max;
        return min;
    }

    public ListNode helpMerge(ListNode l, ListNode r) {
        ListNode head = null;
        ListNode res = null;
        while (len > 0) {
            len--;
            ListNode add = null;
            if (l == null) {
                head.next = r;
                return res;
            }
            if (r == null) {
                head.next = l;
                return res;
            }
            if (l.val > r.val) {
                add = r;
                r = r.next;
            } else {
                add = l;
                l = l.next;
            }
            if (head == null) {
                head = new ListNode(add.val);
                res = head;
                continue;
            }
            head.next = new ListNode(add.val);
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode b = new ListNode(-1);
        ListNode a = new ListNode(5);
        ListNode d = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode e = new ListNode(4);
        b.next = a;
        a.next = d;
        d.next = c;
        c.next  =e;
        new SortList().sortList(b);
    }
}
