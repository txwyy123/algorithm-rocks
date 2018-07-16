package leetcode.e11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/14.
 */
public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        if(nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length){
            if(i == 0 || nums[i] != nums[i-1]){
                int m = i+1;
                int n = nums.length-1;
                while(m < n){
                    if(nums[m]+nums[n] == -nums[i]) {
                        result.add(Arrays.asList(nums[m], nums[n], nums[i]));
                        while(m < nums.length-1 && nums[m+1] == nums[m])
                            m++;
                        m++;
                        while(n > 0 && nums[n-1] == nums[n])
                            n--;
                        n--;
                    }
                    else if(nums[m]+nums[n] < -nums[i])
                        m++;
                    else
                        n--;
                }
            }
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
