package leetcode.e13;

import leetcode.e4.No23;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No92 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return head;

        int index = 1;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode pre = fakeHead;

        while(index != m){
            pre = cur;
            cur = cur.next;
            index++;
        }

        while(index != n){
            ListNode next = cur.next;
            ListNode preNext = pre.next;
            pre.next = cur.next;
            if(next != null) {
                cur.next = cur.next.next;
                next.next = preNext;
            }
            index++;
        }

        return fakeHead.next;
    }

    public static void main(String[] args){
        No92 no92 = new No92();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        no92.reverseBetween(n1, 2, 4);
    }
}
