package leetcode.e6;

import java.util.Arrays;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[][] memo = new int[nums.length+1][nums.length];
        for(int[] l : memo)
            Arrays.fill(l, -1);
        int result = doFind(nums, -1, 0, memo);
        return result;
    }

    private int doFind(int[] nums, int prevIndex, int index, int[][] memo){
        if(index >= nums.length)
            return 0;

        if(memo[prevIndex+1][index] >= 0)
            return memo[prevIndex+1][index];

        int first = 0;
        int second = 0;
        if(prevIndex < 0 || nums[index] > nums[prevIndex]){
            first = doFind(nums, index, index+1, memo)+1;
        }
        second = doFind(nums, prevIndex, index+1, memo);

        int result = Math.max(first, second);
        memo[prevIndex+1][index] = result;
        return result;
    }

    public static void main(String[] args){
        No300 no300 = new No300();
        int[] a = {10,9,2,5,3,7,101,18};
        System.out.print(no300.lengthOfLIS(a));
    }
}
