package leetcode.e42;

/**
 * Created by txwyy123 on 18/8/16.
 */
public class No647 {

    public int countSubstrings(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int count = 0;
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            isPalin[i][i] = true;
            count++;
            if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                isPalin[i][i + 1] = true;
                count++;
            }
        }

        for(int i = 0; i < s.length()-2; i++){
            for(int j = 0; j < s.length()-i-2; j++){
                if(isPalin[j+1][j+1+i] && s.charAt(j) == s.charAt(j+2+i)) {
                    isPalin[j][j + 2 + i] = true;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        No647 no647 = new No647();
        String s = "abc";
        System.out.print(no647.countSubstrings(s));
    }
}
