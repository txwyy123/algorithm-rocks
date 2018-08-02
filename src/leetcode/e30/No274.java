package leetcode.e30;

import java.util.Arrays;

/**
 * Created by txwyy123 on 18/8/2.
 */
public class No274 {

    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;

        Arrays.sort(citations);
        for(int i = citations.length; i >= 1; i--){
            if((citations.length == i || citations[citations.length-i-1] <= i) && citations[citations.length-i] >= i)
                return i;
        }

        return 0;
    }

    public static void main(String[] args){
        No274 no274 = new No274();
        int[] a = {3,0,6,1,5};
        System.out.print(no274.hIndex(a));
    }
}
