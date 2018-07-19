package leetcode.e14;

import java.util.*;

/**
 * Created by txwyy123 on 18/7/17.
 */
public class No438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length-p.length()+1; i++){
            int[] count = new int[26];
            for(char c : p.toCharArray())
                count[c-'a']++;
            for(int j = i; j < i+p.length(); j++){
                if(count[array[j]-'a'] > 0){
                    count[array[j]-'a']--;
                }else{
                    break;
                }

                if(j == i+p.length()-1)
                    result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        No438 no438 = new No438();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.print(no438.findAnagrams(s, p));
    }
}
