package leetcode.e1;

/**
 * Created by txwyy123 on 18/7/3.
 */
public class No494 {

    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0 && S != 0)
            return 0;
        if(nums.length == 1) {
            if(nums[0] == 0 && S == 0)
                return 2;
            if(nums[0] == S || nums[0] == -S)
                return 1;
        }

        int[] copy = new int[nums.length-1];
        System.arraycopy(nums, 1, copy, 0, copy.length);
        return findTargetSumWays(copy, S-nums[0])+findTargetSumWays(copy, S+nums[0]);
    }

    public static void main(String[] args){
        No494 no494 = new No494();
        int[] a = {1,0};
        int sum = 1;
        System.out.print(no494.findTargetSumWays(a, sum));
    }
}
