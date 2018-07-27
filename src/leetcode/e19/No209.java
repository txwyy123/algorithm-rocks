package leetcode.e19;

/**
 * Created by txwyy123 on 18/7/26.
 */
public class No209 {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int result = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = nums[end];

        while(start < nums.length){
            if(sum >= s){
                if(end-start+1 < result)
                    result = end-start+1;
                if(sum == s){
                    sum = sum-nums[start];
                    start++;
                    end++;
                    if(end < nums.length)
                        sum = sum+nums[end];
                }else{
                    sum = sum-nums[start];
                    start++;
                }
            }else{
                end++;
                if(end < nums.length)
                    sum = sum+nums[end];
                else
                    break;
            }
        }

        if(result == Integer.MAX_VALUE)
            return 0;
        return result;
    }

    public static void main(String[] args){
        No209 no209 = new No209();
        int s = 8;
        int[] a = {8};
        System.out.print(no209.minSubArrayLen(s, a));
    }
}
