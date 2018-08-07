package leetcode.e33;

import java.util.Arrays;

/**
 * Created by txwyy123 on 18/8/7.
 */
public class No16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
        for(int i = 0; i < nums.length-2; i++){
            int m = i+1;
            int n = nums.length-1;
            while(m < n){
                int sum = nums[i]+nums[m]+nums[n];
                if(sum == target)
                    return target;
                else{
                    if(sum < target){
                        m++;
                    }else{
                        n--;
                    }

                    if(Math.abs(result-target) > Math.abs(sum-target)) {
                        result = sum;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        No16 no16 = new No16();
        int[] a = {-1,2,1,-4};
        System.out.print(no16.threeSumClosest(a, 1));
    }
}
