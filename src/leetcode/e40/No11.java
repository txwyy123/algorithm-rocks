package leetcode.e40;

/**
 * Created by txwyy123 on 18/8/14.
 */
public class No11 {

    public int maxArea(int[] height) {
        int result = 0;
        for(int i = 1; i < height.length; i++){
            for(int j = 0; i+j < height.length; j++){
                result = Math.max(result, i*(Math.min(height[j],height[j+i])));
            }
        }
        return result;
    }
}
