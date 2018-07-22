package leetcode.e16;

/**
 * Created by txwyy123 on 18/7/20.
 */
public class No387 {

    public int firstUniqChar(String s) {
        if(s == null || s.isEmpty())
            return -1;

        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c-'a']++;

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(count[c-'a'] == 1)
                return i;
        }

        return -1;

    }
}
