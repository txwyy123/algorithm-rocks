package leetcode.e40;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by txwyy123 on 18/8/14.
 */
public class No217 {

    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1)
            return false;

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if (set.contains(i))
                return true;
            else
                set.add(i);
        }

        return false;
    }
}
