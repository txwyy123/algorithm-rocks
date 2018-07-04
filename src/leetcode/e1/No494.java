package leetcode.e1;

/**
 * Created by txwyy123 on 18/7/3.
 */
public class No494 {

    public int findTargetSumWays(int[] nums, int S) {
        return doFind(nums, 0, S);
    }

    private int doFind(int[] nums, int index, int S){
        if(index >= nums.length && S != 0)
            return 0;
        if(index == nums.length-1){
            if(nums[index] == 0 && S == 0)
                return 2;
            if(nums[index] == S || nums[index] == -S)
                return 1;
        }

        return doFind(nums, index+1, S-nums[index])+doFind(nums, index+1, S+nums[index]);
    }
    public int findTargetSumWays1(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum < S || (sum + S) % 2 > 0 ? 0 : subsum(nums, (sum + S) >>> 1);
    }

    public int subsum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }

    public static void main(String[] args){
        No494 no494 = new No494();
        int[] a = {1,1,1,1,1};
        int sum = 3;
        System.out.print(no494.findTargetSumWays1(a, sum));
    }
}
