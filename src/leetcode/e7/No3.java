package leetcode.e7;

/**
 * Created by txwyy123 on 18/7/9.
 */
public class No3 {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty())
            return 0;

        String curStr = "";
        int maxLen = 0;

        for(int i = 0; i < s.length(); i++){
            int index = curStr.indexOf(s.charAt(i));
            if(index < 0){
                curStr += Character.toString(s.charAt(i));
            }else{
                curStr = curStr.substring(index+1)+s.charAt(i);
            }
            maxLen = Math.max(curStr.length(), maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args){
        No3 no3 = new No3();
        String s = "abcabcbb";
        System.out.print(no3.lengthOfLongestSubstring(s));
    }
}
