package leetcode.e47;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/22.
 */
public class No76 {

    public String minWindow(String s, String t) {
        if(s == null || s.isEmpty())
            return "";

        int[] chars = new int[128];
        int[] window = new int[128];
        int count = 0;
        int i = 0;
        String result = "";

        for(char c : t.toCharArray()) {
            chars[c]++;
        }

        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(chars[c] > 0){
                window[c]++;
                if(window[c] <= chars[c])
                    count++;
            }

            if(count == t.length()){
                while(chars[s.charAt(i)] <= 0 || window[s.charAt(i)] > chars[s.charAt(i)]){
                    window[s.charAt(i)]--;
                    i++;
                }

                result = "".equals(result) || result.length() > (j-i) ? s.substring(i, j+1) : result;
            }
        }

        return result;
    }

    public static void main(String[] args){
        No76 no76 = new No76();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.print(no76.minWindow(s, t));
    }
}
