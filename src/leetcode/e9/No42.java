package leetcode.e9;

/**
 * Created by txwyy123 on 18/7/11.
 */
public class No42 {

    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;

        int result = 0;
        for(int i = 1; i < height.length-1; i++) {
            int lMax = 0;
            int rMax = 0;
            for (int j = i; j >= 0; j--) {
                if (height[j] > lMax)
                    lMax = height[j];
            }
            for (int j = i; j < height.length; j++) {
                if (height[j] > rMax)
                    rMax = height[j];
            }

            result += Math.min(lMax, rMax)-height[i];
        }
        return result;
    }

    public static void main(String[] args){
        No42 no42 = new No42();
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(no42.trap(a));
    }
}
