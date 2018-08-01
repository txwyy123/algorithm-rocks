package leetcode.e29;

/**
 * Created by txwyy123 on 18/8/1.
 */
public class No96 {

    public int numTrees(int n) {
        if(n <= 0)
            return 0;

        Integer[] memo = new Integer[n];
        return doCount(1, n, memo);
    }

    private int doCount(int left, int right, Integer[] memo){
        if(left >= right)
            return 1;

        if(memo[right-left] != null)
            return memo[right-left];

        int result = 0;
        for(int i = left; i <= right; i++){
            result += doCount(left, i-1, memo)*doCount(i+1, right, memo);
        }

        memo[right-left] = result;
        return result;
    }

    public static void main(String[] args) {
        No96 no96 = new No96();
        System.out.print(no96.numTrees(3));
    }
}
