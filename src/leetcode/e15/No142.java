package leetcode.e15;

/**
 * Created by txwyy123 on 18/7/19.
 */
public class No142 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        ListNode first = head;
        ListNode second = head;
        int count = 0;

        while(second.next != null && second.next.next != null){
            first = first.next;
            second = second.next.next;
            count++;
            if(first == second) {
                ListNode cur = head;
                while(cur != first){
                    cur = cur.next;
                    first = first.next;
                }
                return cur;
            }
        }

        return null;
    }

    public static void main(String[] args){
        No142 no142 = new No142();
        ListNode n1 = new ListNode(1);
        n1.next = n1;
        System.out.print(no142.detectCycle(n1));
    }
}
