package leetcode.e46;

/**
 * Created by txwyy123 on 18/8/21.
 */
public class No125 {

    public boolean isPalindrome(String s) {
        if(s == null || s.isEmpty())
            return true;

        int i = 0, j = s.length()-1;
        while(i < j){
            while (i < j && !isValidChar(s.charAt(i)))
                i++;
            while (j > i && !isValidChar(s.charAt(j)))
                j--;
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            i++;
            j--;
        }

        return true;
    }

    boolean isValidChar(char c){
        if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }

    public static void main(String[] args){
        No125 no125 = new No125();
        String s = "0P";
        System.out.print(no125.isPalindrome(s));
    }
}
