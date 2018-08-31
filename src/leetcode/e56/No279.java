package leetcode.e56;

/**
 * Created by txwyy123 on 18/8/30.
 */
public class No279 {

    public int numSquares(int n) {
        int[] memo = new int[n+1];
        return doFind(n, memo);
    }

    int doFind(int n, int[] memo){
        if(memo[n] != 0)
            return memo[n];

        if(isSquare(n)) {
            memo[n] = 1;
            return 1;
        }

        int result = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            result = Math.min(1+doFind(n-i*i, memo), result);
        }
        memo[n] = result;
        return result;
    }

    boolean isSquare(int n){
        for(int i = 1; i <= n; i++){
            if(i*i == n)
                return true;
            else if(i*i > n)
                return false;
        }
        return false;
    }

    public static void main(String[] args){
        No279 no279 = new No279();
        int n = 63;
        System.out.print(no279.numSquares(n));
    }
}
