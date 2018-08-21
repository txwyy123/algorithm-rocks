package leetcode.e45;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/21.
 */
public class No138 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;

        RandomListNode cur = head;
        RandomListNode headCopy = null;
        RandomListNode curCopy = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while(cur != null){
            curCopy = map.get(cur);
            if(curCopy == null){
                curCopy = new RandomListNode(cur.label);
                map.put(cur, curCopy);
            }

            RandomListNode next = map.get(cur.next);
            if(next == null && cur.next != null){
                next = new RandomListNode(cur.next.label);
                map.put(cur.next, next);
            }

            RandomListNode random = map.get(cur.random);
            if(random == null && cur.random != null){
                random = new RandomListNode(cur.random.label);
                map.put(cur.random, random);
            }

            curCopy.next = next;
            curCopy.random = random;

            if(headCopy == null)
                headCopy = curCopy;

            cur = cur.next;
        }

        return headCopy;
    }

    public static void main(String[] args){
        No138 no138 = new No138();
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        n1.next = n2;
        n1.random = n2;
        n2.random = n2;
        no138.copyRandomList(n1);
    }
}
