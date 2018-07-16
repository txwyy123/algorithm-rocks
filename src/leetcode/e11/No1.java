package leetcode.e11;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/7/14.
 */
public class No1 {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length == 0)
            return null;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
