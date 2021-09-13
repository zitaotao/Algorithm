package leetcode;

import leetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 *
 * https://lyl0724.github.io/2020/01/25/1/
 * 递归
 *
 * @Author user
 * @Date 2020-12-19 16:14
 * @Version 1.0
 **/
public class SwapPairs {

    public static ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        List<ListNode> odd = new ArrayList<>();
        List<ListNode> even = new ArrayList<>();
        ListNode tempHead = head;
        Integer len  = 0;
        for (int index=1;;index++){
            len++;
            if(index%2==0){
                even.add(tempHead);
            }
            if (index%2!=0){
                odd.add(tempHead);
            }
            tempHead = tempHead.next;
            if (tempHead==null){
                break;
            }
        }
        tempHead = null;
        for (int index=0;index<odd.size();index++){

            if (tempHead==null){
                tempHead = even.get(index);
                tempHead.next = odd.get(index);
                tempHead = tempHead.next;
            }

            if (len%2==0){

                if (tempHead!=null){
                    tempHead.next = even.get(index);
                    tempHead.next.next = odd.get(index);
                    tempHead = even.get(index).next;

                    if (index==odd.size()-1){
                        tempHead.next = null;
                    }
                }



            }

            if (len%2!=0){

                if (tempHead!=null){
                    if (index==odd.size()-1){
                        tempHead.next = odd.get(index);
                        tempHead.next.next = null;
                    }
                    if (index!=odd.size()-1){
                        tempHead.next = even.get(index);
                        tempHead.next.next = odd.get(index);
                        tempHead = even.get(index).next;
                    }

                }
            }

        }
        return even.get(0);
    }



    /**
     * 递归的解法
     * 1,2,3,4
     **/
    public static ListNode swapPairsRecursion(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursion(newHead.next);
        newHead.next = head;
        return newHead;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        swapPairs(a);
    }



}
