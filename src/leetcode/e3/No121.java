package leetcode.e3;

/**
 * Created by txwyy123 on 18/7/5.
 */
public class No121 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i]-min);
        }

        return result;
    }
}
