package leetcode.e2;

/**
 * Created by txwyy123 on 18/7/4.
 */
public class No198 {

    public int rob(int[] nums) {
        Integer[] max = new Integer[nums.length];
        return Math.max(rob(nums, 0, max), rob(nums, 1, max));
    }

    private int rob(int[] nums, int start, Integer[] max){
        if(start >= nums.length)
            return 0;

        if(max[start] != null)
            return max[start];

        int first = rob(nums, start+2, max);
        int second = rob(nums, start+3, max);
        int result = Math.max(first, second)+nums[start];
        max[start] = result;
        return result;
    }

    public int rob1(int[] nums){
        if(nums.length == 0)
            return 0;

        int[] result = new int[nums.length+1];
        result[0] = 0;
        result[1] = nums[0];
        for(int i = 2; i < result.length; i++){
            result[i] = Math.max(result[i-1], result[i-2]+nums[i-1]);
        }
        return result[result.length-1];
    }

    public static void main(String[] args){
        No198 no198 = new No198();
        int[] a = {1,2,3,1};
        System.out.print(no198.rob1(a));
    }
}
