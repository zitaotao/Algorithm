package leetcode;

import leetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 双指针
 * @Date 2020-12-20 11:29
 * @Version 1.0
 **/
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode a = head.next;
        ListNode b = head;
        boolean cycle = true;
        while(cycle){
            if(a==null || b==null){
                return false;
            }

            if(a==b){
                return true;
            }
            if(a.next==null){
                return false;
            }
            a = a.next.next;
            b = b.next;

        }
        return false;
    }

    /**
     * 找出成环位置
     * 进阶：
     *
     * 使用 O(1) 空间解决此题  todo
     **/
    public ListNode detectCycle(ListNode head) {
        if(!hasCycle(head)){
            return null;
        }
        boolean cycle = true;
        ListNode a = head;
        List<ListNode> nodes = new ArrayList<>();
        while(cycle){
            if(nodes.contains(a.next)){
                return a.next;
            }
            nodes.add(a);
            a=a.next;
        }
        return null;
    }

}
