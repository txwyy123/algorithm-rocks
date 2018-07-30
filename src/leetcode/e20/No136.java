package leetcode.e20;

/**
 * Created by txwyy123 on 18/7/28.
 */
public class No136 {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++)
            result ^= nums[i];
        return result;
    }
}
