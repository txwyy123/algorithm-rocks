package leetcode.e45;

/**
 * Created by txwyy123 on 18/8/21.
 */
public class No696 {

    public int countBinarySubstrings(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int result = 0;
        int prev = 0;
        int cur = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cur++;
            }else{
                result += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
        }

        result += Math.min(prev, cur);
        return result;
    }

    public static void main(String[] args){
        No696 no696 = new No696();
        String s = "00110011";
        System.out.print(no696.countBinarySubstrings(s));
    }
}
