package leetcode.e48;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/23.
 */
public class No692 {

    class Frequency{
        String str;
        int freq;
    }

    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Frequency> queue = new PriorityQueue<Frequency>(new Comparator<Frequency>() {
            @Override
            public int compare(Frequency o1, Frequency o2) {
                if(o2.freq > o1.freq){
                    return 1;
                }else if(o2.freq < o1.freq){
                    return -1;
                }

                int i = 0;
                int j = 0;
                while (i < o1.str.length() || j < o2.str.length()){
                    char c1 = i < o1.str.length() ? o1.str.charAt(i++) : 'a'-1;
                    char c2 = j < o2.str.length() ? o2.str.charAt(j++) : 'b'-1;

                    if(c1 < c2){
                        return -1;
                    }else if(c1 > c2){
                        return 1;
                    }
                }

                return 0;
            }
        });

        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(map.containsKey(str))
                map.put(str, map.get(str)+1);
            else
                map.put(str, 1);
        }

        for(String str : map.keySet()){
            Frequency freq = new Frequency();
            freq.freq = map.get(str);
            freq.str = str;
            queue.add(freq);
        }

        int count = 0;
        List<String> result = new ArrayList<>();
        while(count < k){
            result.add(queue.poll().str);
            count++;
        }
        return result;
    }

    public static void main(String[] args){
        No692 no692 = new No692();
        String[] words = {"a", "aa", "aaa"};
        int k = 1;
        System.out.print(no692.topKFrequent(words, k));
    }
}
