package leetcode.e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by txwyy123 on 18/7/4.
 */
public class No347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? 1 : (o1 == o2 ? 0 : -1);
                }
            }
        );

        for(int num : nums){
            queue.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(queue.poll());
        }

        return result;
    }
}
