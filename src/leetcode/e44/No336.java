package leetcode.e44;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/20.
 */
public class No336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if(words == null || words.length == 0)
            return result;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int l = 0, r = 0;
            while(l <= r){
                String sub = word.substring(l, r);
                Integer j = map.get(new StringBuilder(sub).reverse().toString());
                if(j != null && i != j && isPalin(word.substring(l == 0 ? r : 0, l == 0 ? word.length() : l))) {
                    if(l == 0)
                        result.add(Arrays.asList(i, j));
                    else
                        result.add(Arrays.asList(j, i));
                }

                if(r < word.length())
                    r++;
                else
                    l++;
            }
        }

        return result;
    }

    boolean isPalin(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        No336 no336 = new No336();
        String[] words = {"a",""};
        System.out.print(no336.palindromePairs(words));
    }
}
