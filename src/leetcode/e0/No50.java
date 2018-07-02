package leetcode.e0;

/**
 * Created by txwyy123 on 18/7/2.
 */
public class No50 {

    public double myPow(double x, int n) {
        if(n == 0)
            return 1;

        boolean isPostive = n > 0;
        n = n < 0 ? -n : n;
        double result = doPow(x, n);
        return isPostive ? result : 1/result;
    }

    private double doPow(double x, int n){
        if(n == 0)
            return 1;
        double half = doPow(x*x, n/2);
        return n%2 == 0 ? half : half*x;
    }

    public static void main(String[] args){
        No50 no50 = new No50();
        System.out.print(no50.myPow(2.0, -2));
    }
}
