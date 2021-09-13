package leetcode;

import leetcode.data.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/rotate-list/
 * 旋转链表
 *
 * @Author user
 * @Date 2020-12-21 11:06
 * @Version 1.0
 **/
public class rotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null||head.next==null){
            return head;
        }
        if (k==0){
            return head;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode end = head;
        while (end!=null){
            listNodeList.add(end);
            end = end.next;
        }
        k = k%listNodeList.size();

        for (int num = 0;num<k;num++){
            listNodeList.add(0,listNodeList.get(listNodeList.size()-1));
            listNodeList.remove(listNodeList.size()-1);
            listNodeList.get(listNodeList.size()-1).next = null;
        }
        ListNode tempHead = listNodeList.get(0);
        for (int i = 1; i < listNodeList.size(); i++) {
            tempHead.next = listNodeList.get(i);
            tempHead = listNodeList.get(i);
        }
        return listNodeList.get(0);
    }

    public static void main(String[] args) {
    }


}
