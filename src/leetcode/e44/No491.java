package leetcode.e44;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/8/20.
 */
public class No491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        doFind(nums, 0, new ArrayList<Integer>(), result);
        return new ArrayList<>(result);
    }

    void doFind(int[] nums, int index, List<Integer> temp, Set<List<Integer>> result){
        if(temp.size() > 1) {
            result.add(new ArrayList<>(temp));
        }

        if(index == nums.length) {
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(temp.isEmpty() || temp.get(temp.size()-1) <= nums[i]){
                temp.add(nums[i]);
                if(!result.contains(temp)) {
                    doFind(nums, i + 1, temp, result);
                }
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args){
        No491 no491 = new No491();
        int[] nums = {4,6,7,7};
        System.out.print(no491.findSubsequences(nums));
    }
}
