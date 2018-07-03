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

    public static void main(String[] args){
        No494 no494 = new No494();
        int[] a = {1,0};
        int sum = 1;
        System.out.print(no494.findTargetSumWays(a, sum));
    }
}
