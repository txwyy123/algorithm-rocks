package leetcode.e44;

/**
 * Created by txwyy123 on 18/8/20.
 */
public class No680 {

    public boolean validPalindrome(String s) {
        if(s == null || s.isEmpty())
            return false;

        return doValid(s, 0, s.length()-1, false);
    }

    boolean doValid(String s, int l, int r, boolean hasChanged){
        if(l > r)
            return true;

        boolean result = false;
        if(s.charAt(l) == s.charAt(r)){
            result |= doValid(s, l+1, r-1, hasChanged);
        }else{
            if(hasChanged){
                result = false;
            }else{
                result |= doValid(s, l+1, r, true) | doValid(s, l, r-1, true);
            }
        }

        return result;
    }

    public static void main(String[] args){
        No680 no680 = new No680();
        String s = "aba";
        System.out.print(no680.validPalindrome(s));
    }
}
