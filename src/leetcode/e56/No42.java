package leetcode.e56;

/**
 * Created by txwyy123 on 18/8/30.
 */
public class No42 {

    public int trap(int[] height) {
        int result = 0;
        for(int i = 1; i < height.length-1; i++){
            int lMax = 0;
            int rMax = 0;
            for(int j = i-1; j >= 0; j--)
                lMax = Math.max(lMax, height[j]);
            for(int k = i+1; k < height.length; k++)
                rMax = Math.max(rMax, height[k]);
            int water = Math.min(lMax, rMax)-height[i];
            result += water > 0 ? water : 0;
        }
        return result;
    }

    public int trap1(int[] height) {
        int result = 0;
        if(height.length <= 2)
            return result;

        int[] lMax = new int[height.length-2];
        int[] rMax = new int[height.length-2];

        int max = height[0];
        for(int i = 0; i < lMax.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            lMax[i] = max;
        }

        max = height[height.length-1];
        for(int i = height.length-1; i >= 2; i--){
            if(height[i] > max){
                max = height[i];
            }
            rMax[i-2] = max;
        }

        for(int i = 1; i < height.length-1; i++){
            int water = Math.min(lMax[i-1], rMax[i-1])-height[i];
            result += water > 0 ? water : 0;
        }
        return result;
    }
}
