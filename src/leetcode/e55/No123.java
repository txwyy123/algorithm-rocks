package leetcode.e55;

/**
 * Created by txwyy123 on 18/8/29.
 */
public class No123 {

    public int maxProfit(int[] prices) {
        int[] first = new int[prices.length];
        int[] second = new int[prices.length];

        int min = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < prices[min])
                min = i;
            first[i] = Math.max(prices[i]-prices[min], first[i-1]);
        }

        int max = prices.length-1;
        for(int i = prices.length-2; i >= 0; i--){
            if(prices[i] > prices[max])
                max = i;
            second[prices.length-i-1] = Math.max(prices[max]-prices[i], second[prices.length-i-2]);
        }

        int result = 0;
        for(int i = 0; i < prices.length; i++){
            result = Math.max(result, first[i]+second[prices.length-i-1]);
        }

        return result;
    }

    public static void main(String[] args){
        No123 no123 = new No123();
        int[] a = {3,2};
        System.out.print(no123.maxProfit(a));
    }
}
