package leetcode.e48;

/**
 * Created by txwyy123 on 18/8/23.
 */
public class No53 {

    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static void main(String[] args){
        No53 no53 = new No53();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(no53.maxSubArray(a));
    }
}
