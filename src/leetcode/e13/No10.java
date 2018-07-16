package leetcode.e13;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No10 {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;

        Boolean[][] memo = new Boolean[s.length()+1][p.length()+1];
        return doMatch(s, p, 0, 0, memo);
    }

    private boolean doMatch(String s, String p, int i, int j, Boolean[][] memo){
        if(j >= p.length())
            return i >= s.length();

        if(memo[i][j] != null)
            return memo[i][j];

        boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean result = false;
        if(j < p.length()-1 && p.charAt(j+1) == '*'){
            result = doMatch(s, p, i, j+2, memo) || (firstMatch && doMatch(s, p, i+1, j, memo));
        }else{
            result = firstMatch && doMatch(s, p, i+1, j+1, memo);
        }

        memo[i][j] = result;
        return result;
    }

    public static void main(String[] args){
        No10 no10 = new No10();
        String s = "ab";
        String p = ".*c";
        System.out.print(no10.isMatch(s, p));
    }
}