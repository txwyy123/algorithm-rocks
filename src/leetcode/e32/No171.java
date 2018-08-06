package leetcode.e32;

/**
 * Created by txwyy123 on 18/8/6.
 */
public class No171 {

    public int titleToNumber(String s) {
        if(s == null || s.isEmpty())
            return 0;

        char[] chars = s.toCharArray();
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result += Math.pow(26, s.length()-i-1)*(chars[i]-'A'+1);
        }

        return result;
    }

    public static void main(String[] args){
        No171 no171 = new No171();
        System.out.print(no171.titleToNumber("A"));
    }
}
