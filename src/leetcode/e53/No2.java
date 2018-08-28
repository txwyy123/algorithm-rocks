package leetcode.e53;

import leetcode.e52.No206;

/**
 * Created by txwyy123 on 18/8/28.
 */
public class No2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int carry = 0;

        while(cur1 != null || cur2 != null){
            int first = cur1 == null ? 0 : cur1.val;
            int second = cur2 == null ? 0 : cur2.val;
            int sum = first+second+carry;
            if(sum >= 10){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }


            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = cur1 == null ? null : cur1.next;
            cur2 = cur2 == null ? null : cur2.next;
        }

        if(carry != 0) {
            cur.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args){
        No2 no2 = new No2();
        ListNode n1 = new ListNode(5);
        ListNode n4 = new ListNode(5);
        ListNode result = no2.addTwoNumbers(n1, n4);
        System.out.print(result);
    }
}
