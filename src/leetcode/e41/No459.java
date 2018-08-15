package leetcode.e41;

/**
 * Created by txwyy123 on 18/8/15.
 */
public class No459 {

    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.isEmpty())
            return false;

        String temp = "";
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length/2; i++){
            temp += chars[i];
            if(s.length()%(i+1) == 0){
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < s.length()/(i+1); j++){
                    str.append(temp);
                }

                if(str.toString().equals(s))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        No459 no459 = new No459();
        System.out.print(no459.repeatedSubstringPattern("aba"));
    }
}
