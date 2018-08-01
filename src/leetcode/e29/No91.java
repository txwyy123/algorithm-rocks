package leetcode.e29;

/**
 * Created by txwyy123 on 18/7/31.
 */
public class No91 {

    public int numDecodings(String s) {
        if(s == null || s.isEmpty())
            return 0;

        Integer[] memo = new Integer[s.length()];
        return doDecoding(s, 0, memo);
    }

    private int doDecoding(String s, int i, Integer[] memo){
        if(i >= s.length())
            return 0;

        int result = 0;
        int num1 = s.charAt(i)-'0';
        if(num1 <= 0 || num1 > 9){
            if(i < s.length()-1){
                int num2 = (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                if(num2 < 10 || num2 > 26)
                    result = 0;
                else{
                    if(i+2<s.length() && memo[i+2] != null)
                        result = memo[i+2];
                    else{
                        if(i+2 == s.length())
                            result = 1;
                        else
                            result = doDecoding(s, i+2, memo);
                    }
                }
            }else{
                result = 0;
            }
        }else{
            if(i+1<s.length() && memo[i+1] != null)
                result = memo[i+1];
            else {
                if(i+1 == s.length())
                    result = 1;
                else
                    result = doDecoding(s, i + 1, memo);
            }

            if(i < s.length()-1){
                int num2 = (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0');
                if(num2 < 10 || num2 > 26)
                    result += 0;
                else{
                    if(i+2<s.length() && memo[i+2] != null)
                        result += memo[i+2];
                    else {
                        if (i + 2 == s.length())
                            result += 1;
                        else
                            result += doDecoding(s, i + 2, memo);
                    }
                }
            }else{
                result += 0;
            }

        }

        memo[i] = result;
        return result;
    }

    public static void main(String[] args){
        No91 no91 = new No91();
        String s = "226";
        System.out.print(no91.numDecodings(s));
    }
}
