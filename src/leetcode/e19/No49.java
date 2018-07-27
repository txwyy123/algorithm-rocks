package leetcode.e19;

import java.util.*;

/**
 * Created by txwyy123 on 18/7/25.
 */
public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list;
            if(map.keySet().contains(s)){
                list = map.get(s);
            }else{
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(s, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args){
        No49 no49 = new No49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.print(no49.groupAnagrams(strs));
    }
}
