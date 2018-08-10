package leetcode.e35;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/9.
 */
public class No354 {

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0] == 0 ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        int result = 0;
        int[] memo = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++) {
            result = Math.max(result, doFind(envelopes, i, memo));
        }
        return result;
    }

    private int doFind(int[][] envelopes, int index, int[] memo){
        if(index >= envelopes.length)
            return 0;

        if(memo[index] != 0)
            return memo[index];

        int result = 1;
        int[] first = envelopes[index];
        for(int i = index+1; i < envelopes.length; i++) {
            if(envelopes[i][0] > first[0] && envelopes[i][1] > first[1]){
                result = Math.max(result, 1+doFind(envelopes, i, memo));
            }
        }
        memo[index] = result;
        return result;
    }

    public static void main(String[] args){
        No354 no354 = new No354();
        int[][] a = {{46,89}, {50,53}, {52,68}, {72,45}, {77,81}};
        System.out.print(no354.maxEnvelopes(a));
    }
}
