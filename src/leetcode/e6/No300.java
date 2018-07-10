package leetcode.e6;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        return doFind(nums, Integer.MIN_VALUE, 0);
    }

    private int doFind(int[] nums, int prev, int index){
        if(index >= nums.length)
            return 0;

        int first = 0;
        int second = 0;
        if(nums[index] > prev){
            first = doFind(nums, nums[index], index+1)+1;
        }
        second = doFind(nums, prev, index+1);

        return Math.max(first, second);
    }

    public static void main(String[] args){
        No300 no300 = new No300();
        int[] a = {10,9,2,5,3,4};
        System.out.print(no300.lengthOfLIS(a));
    }
}
