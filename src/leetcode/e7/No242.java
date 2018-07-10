package leetcode.e7;

/**
 * Created by txwyy123 on 18/7/10.
 */
public class No242 {

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;

        if(s.length() != t.length())
            return false;

        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(map[i] != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args){
        No242 no242 = new No242();
        no242.isAnagram("anagram", "nagaram");
    }
}
