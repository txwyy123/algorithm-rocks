package leetcode.e52;

/**
 * Created by txwyy123 on 18/8/27.
 */
public class No206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;

        ListNode cur = head.next;
        ListNode pre = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            head.next = next;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args){
        No206 no206 = new No206();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        no206.reverseList(n1);
    }
}
