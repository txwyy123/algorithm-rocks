package leetcode.e57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by txwyy123 on 18/9/2.
 */
public class No18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]){
                for(int m = i+1; m < nums.length; m++){
                    if(m == i+1 || nums[m] != nums[m-1]){
                        int j = m+1;
                        int k = nums.length-1;
                        while(j < k) {
                            int sum = nums[i] + nums[j] + nums[k] + nums[m];
                            if (sum == target) {
                                result.add(Arrays.asList(nums[i], nums[m], nums[j], nums[k]));
                                while(j < k && nums[j+1] == nums[j])
                                    j++;
                                while(j < k && nums[k-1] == nums[k])
                                    k--;
                                j++;
                                k--;
                            }else if(sum < target)
                                j++;
                            else
                                k--;
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        No18 no18 = new No18();
        int[] a = {-3,-1,0,2,4,5};
        System.out.print(no18.fourSum(a, 2));
    }
}
