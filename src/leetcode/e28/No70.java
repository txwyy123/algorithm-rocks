package leetcode.e28;

/**
 * Created by txwyy123 on 18/7/30.
 */
public class No70 {

    public int climbStairs(int n) {
        if(n <= 2)
            return n;

        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        count[2] = 2;

        for(int i = 3; i <= n; i++){
            count[i] = count[i-1]+count[i-2];
        }

        return count[n];
    }

    public static void main(String[] args){
        No70 no70 = new No70();
        no70.climbStairs(1);
    }
}
