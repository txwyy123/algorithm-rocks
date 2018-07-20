package leetcode.e15;

/**
 * Created by txwyy123 on 18/7/19.
 */
public class No141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;

        ListNode first = head;
        ListNode second = head;

        while(second.next != null && second.next.next != null){
            first = first.next;
            second = second.next.next;
            if(first == second)
                return true;
        }

        return false;
    }
}
