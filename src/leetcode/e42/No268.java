package leetcode.e42;

/**
 * Created by txwyy123 on 18/8/16.
 */
public class No268 {

    public int missingNumber(int[] nums) {
        int[] a = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++)
            a[nums[i]] = nums[i];

        for(int i = 0; i < a.length; i++)
            if(a[i] != i)
                return i;

        return 0;
    }
}
