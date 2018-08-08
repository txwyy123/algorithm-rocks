package leetcode.e34;

/**
 * Created by txwyy123 on 18/8/8.
 */
public class No67 {

    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        String result = "";
        while(i >= 0 || j >= 0){
            int first = i >= 0 ? a.charAt(i)-'0' : 0;
            int second = j >= 0 ? b.charAt(j)-'0' : 0;
            int sum = first+second+carry;
            if(sum > 1){
                sum -= 2;
                carry = 1;
            }else{
                carry = 0;
            }
            result = sum + result;
            i--;
            j--;
        }

        if(carry > 0)
            result = carry + result;
        return result;
    }

    public static void main(String[] args){
        No67 no67 = new No67();
        System.out.print(no67.addBinary("1010", "1011"));
    }
}
