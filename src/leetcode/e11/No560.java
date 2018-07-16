package leetcode.e11;

/**
 * Created by txwyy123 on 18/7/14.
 */
public class No560 {

    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;

        int result = 0;
        int[][] memo = new int[nums.length][nums.length];
        for(int i = nums.length-1; i >= 0; i--){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k)
                    result++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        No560 no560 = new No560();
        int[] a = {1,1,1};
        int k = 2;
        System.out.print(no560.subarraySum(a, k));
    }
}
