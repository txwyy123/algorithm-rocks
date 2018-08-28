package leetcode.e53;

/**
 * Created by txwyy123 on 18/8/28.
 */
public class No415 {

    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int first = i >= 0 ? num1.charAt(i)-'0' : 0;
            int second = j >= 0 ? num2.charAt(j)-'0' : 0;
            int sum = first+second+carry;
            if(sum >= 10){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            result.append((char)(sum+'0'));
            i--;
            j--;
        }

        if (carry != 0)
            result.append((char)(carry+'0'));
        return result.reverse().toString();
    }

    public static void main(String[] args){
        No415 no415 = new No415();
        String str1 = "123";
        String str2 = "999";
        System.out.print(no415.addStrings(str1, str2));
    }
}
