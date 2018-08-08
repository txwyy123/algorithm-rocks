package leetcode.e34;

/**
 * Created by txwyy123 on 18/8/8.
 */
public class No389 {

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()){
            chars[c-'a']++;
        }
        for(char c : t.toCharArray()){
            chars[c-'a']--;
        }
        for(int i = 0; i < 26; i++)
            if(chars[i] == -1)
                return (char) (i+'a');

        return 'a';
    }

    public static void main(String[] args){
        No389 no389 = new No389();
        no389.findTheDifference("abcd", "abcde");
    }
}
