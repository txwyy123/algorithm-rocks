package leetcode.e5;

/**
 * Created by txwyy123 on 18/7/7.
 */
public class No123 {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;

        int result = 0;
        int fMin = Integer.MAX_VALUE;
        int sMin = Integer.MIN_VALUE;
        int fMax = 0;
        int sMax = 0;
        int[] firsts = new int[prices.length];
        int[] seconds = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            fMin = Math.min(prices[i], fMin);
            fMax = Math.max(fMax, prices[i]-fMin);
            firsts[i] = fMax;

            sMin = Math.max(prices[prices.length-i-1], sMin);
            sMax = Math.max(sMax, sMin-prices[prices.length-i-1]);
            seconds[prices.length-i-1] = sMax;
        }

        for(int i = 0; i < prices.length; i++){
            result = firsts[i]+seconds[i] > result ? firsts[i]+seconds[i] : result;
        }

        return result;
    }

    public static void main(String[] args){
        No123 no123 = new No123();
        int[] a = {3,3,5,0,0,3,1,4};
        no123.maxProfit(a);
    }
}
