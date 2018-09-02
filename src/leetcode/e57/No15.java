package leetcode.e57;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/31.
 */
public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length-2){
            int j = i+1;
            int k = nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j+1] == nums[j])
                        j++;
                    while(j < k && nums[k-1] == nums[k])
                        k--;
                    j++;
                    k--;
                }else if(sum < 0)
                    j++;
                else
                    k--;
            }

            while(i < nums.length-2 && nums[i+1] == nums[i])
                i++;
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        No15 no15 = new No15();
        int[] a = {0,0,0};
        System.out.print(no15.threeSum(a));
    }
}
