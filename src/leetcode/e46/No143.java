package leetcode.e46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/22.
 */
public class No143 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if(head == null)
            return;

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            list.add(cur);
            cur = cur.next;
        }

        int i;
        for(i = 0; i < list.size()/2; i++){
            ListNode n1 = list.get(i);
            ListNode n2 = list.get(list.size()-i-1);
            n1.next = n2;
            n2.next = list.get(i+1);
        }

        list.get(i).next = null;
    }

    public static void main(String[] args){
        No143 no143 = new No143();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        no143.reorderList(n1);
        System.out.print(n1);
    }
}
