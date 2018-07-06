package leetcode.e4;

/**
 * Created by txwyy123 on 18/7/6.
 */
public class No66 {
    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length == 0)
            return digits;

        int carry = 0;
        int i = digits.length-1;
        do{
            if(i == digits.length-1)
                digits[i] = digits[i]+carry+1;
            else
                digits[i] = digits[i]+carry;
            carry = digits[i] > 9 ? 1 : 0;
            digits[i] = digits[i] > 9 ? digits[i]-10 : digits[i];
            i--;
        }while (carry != 0 && i >= 0);

        if(carry != 0){
            int[] result = new int[digits.length+1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
            return result;
        }

        return digits;
    }

    public static void main(String[] args){
        No66 no66 = new No66();
        int[] a = {9};
        no66.plusOne(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
        }
    }
}
