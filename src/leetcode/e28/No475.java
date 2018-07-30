package leetcode.e28;

import java.util.Arrays;

/**
 * Created by txwyy123 on 18/7/30.
 */
public class No475 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                    && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }

        return res;
    }

    public static void main(String[] args){
        No475 no475 = new No475();
        int[] houses = {1,5};
        int[] heaters = {2};
        System.out.print(no475.findRadius(houses, heaters));
    }
}
