package leetcode.e46;

/**
 * Created by txwyy123 on 18/8/22.
 */
public class No29 {

    public int divide(int dividend, int divisor) {
        if(dividend == 0)
            return 0;

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        long end = Math.abs((long) dividend);
        long divider = Math.abs((long) divisor);
        long factor = 1;
        while((divider << 1) <= end) {
            divider = divider << 1;
            factor *= 2;
        }

        long result = 0;
        while(factor >= 1){
            if(end >= divider) {
                end -= divider;
                result += factor;
            }
            divider = divider >> 1;
            factor /= 2;
        }

        if((!isNegative && result > Integer.MAX_VALUE) || (isNegative && -result < Integer.MIN_VALUE))
            return Integer.MAX_VALUE;
        return (int) (isNegative ? -result : result);
    }

    public static void main(String[] args){
        No29 no29 = new No29();
        int dividend = -2147483648;
        int divisor = -1;
        System.out.print(no29.divide(dividend, divisor));
    }
}
