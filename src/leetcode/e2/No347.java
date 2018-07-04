package leetcode.e2;

import java.util.*;

/**
 * Created by txwyy123 on 18/7/4.
 */
public class No347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue()-o1.getValue();
                    }
                }
        );

        for(Map.Entry entry : map.entrySet()){
            queue.add(entry);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < k; i++){
            result.add(queue.poll().getKey());
        }

        return result;
    }
}
