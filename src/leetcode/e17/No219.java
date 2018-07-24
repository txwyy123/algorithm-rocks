package leetcode.e17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by txwyy123 on 18/7/24.
 */
public class No219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0)
            return false;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }

        for(Integer key : map.keySet()){
            List<Integer> list = map.get(key);
            for(int i = 0; i < list.size()-1; i++){
                if(list.get(i+1)-list.get(i) <= k)
                    return true;
            }
        }

        return false;
    }
}
