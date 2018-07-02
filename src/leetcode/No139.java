package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/7/2.
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[][] canBreak = new Boolean[s.length()][s.length()];
        return doBreak(s, set, 0, canBreak);
    }

    private boolean doBreak(String s, Set<String> set, int index, Boolean[][] canBreak){
        if(set.contains(s.substring(index)))
            return true;
        if(index >= s.length())
            return false;

        boolean result = false;
        for(int i = index+1; i < s.length()+1; i++){
            if(canBreak[index][i-1] == null) {
                String sub = s.substring(index, i);
                if (set.contains(sub) && doBreak(s, set, i, canBreak)) {
                    canBreak[index][i-1] = true;
                    result = true;
                    break;
                }
                canBreak[index][i-1] = false;
            }else{
                result = canBreak[index][i-1];
            }
        }

        return result;
    }

    public static void main(String[] args){
        No139 no139 = new No139();
        String s = "leetcode";
        List<String> list = Arrays.asList("leet","code");
        System.out.print(no139.wordBreak(s, list));
    }
}
