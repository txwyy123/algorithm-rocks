package leetcode.e37;

/**
 * Created by txwyy123 on 18/8/11.
 */
public class No523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return false;

        for(int i = 0 ; i < nums.length; i++){
            int temp = 0;
            int len = 0;
            for(int j = i ; j < nums.length; j++){
                temp += nums[j];
                len++;
                if(k == 0 && temp == 0 && len >= 2)
                    return true;
                if(k != 0 && temp%k == 0 && len >= 2)
                    return true;
            }
        }

        return false;
    }
}
