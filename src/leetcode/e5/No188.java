package leetcode.e5;

/**
 * Created by txwyy123 on 18/7/7.
 */
public class No188 {

    public int maxProfit(int k, int[] prices) {
        return find(prices, 0, k);
    }

    private int find(int[] prices, int start, int k){
        if(k <= 0 || start >= prices.length)
            return 0;

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = start; i <= prices.length-1; i++){
            int post = find(prices, i+1, k-1);
            int post1 = find(prices, i+1, k);
            min = Math.min(min, prices[i]);
            result = Math.max(Math.max(result+post, prices[i]-min+post), post1);
        }
        return result;
    }

    public static void main(String[] args){
        No188 no188 = new No188();
        int[] a = {3,2,6,5,0,3};
        System.out.print(no188.maxProfit(2, a));
    }
}
