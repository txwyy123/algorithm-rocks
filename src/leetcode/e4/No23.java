package leetcode.e4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by txwyy123 on 18/7/6.
 */
public class No23 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        if(lists == null || lists.length == 0)
            return result.next;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val-o2.val;
                }
            }
        );

        for(ListNode node : lists) {
            if(node != null)
                heap.add(node);
        }

        ListNode cur = result;
        while (!heap.isEmpty()){
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null)
                heap.add(node.next);
        }

        return result.next;
    }

    public static void main(String[] args){
        No23 no23 = new No23();
        ListNode[] a = {};
        no23.mergeKLists(a);
    }
}
