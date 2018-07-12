package leetcode.e9;

import java.util.Arrays;

/**
 * Created by txwyy123 on 18/7/12.
 */
public class No31 {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;

        if(nums[nums.length-1] > nums[nums.length-2]) {
            swap(nums, nums.length - 1, nums.length - 2);
            return;
        }

        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                for(int j = i; j < nums.length; j++){
                    if(j == nums.length-1 || (nums[j] > nums[i-1] && nums[j+1] <= nums[i-1])) {
                        swap(nums, i-1, j);
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }else if(i == 1 && nums[i] <= nums[i-1] ){
                Arrays.sort(nums);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        No31 no31 = new No31();
        int[] a = {5,4,7,5,3,2};
        no31.nextPermutation(a);
        for(int i : a){
            System.out.println(i);
        }
    }
}
