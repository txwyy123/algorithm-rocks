package leetcode.e55;

/**
 * Created by txwyy123 on 18/8/29.
 */
public class No689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] first = new int[nums.length];
        int[] third = new int[nums.length];

        int[] sums = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < sums.length-k+1; i++){
            if(i == 0){
                for(int j = 0; j < k; j++)
                    sum += nums[j];
                sums[i] = sum;
            }else{
                sum = sum+nums[i+k-1]-nums[i-1];
                sums[i] = sum;
            }
        }

        for(int i = 0; i < nums.length-k+1; i++){
            sum = sums[i];
            if(i != 0)
                first[i] = sum > sums[first[i - 1]] ? i : first[i - 1];
            else
                first[i] = 0;
        }

        for(int i = nums.length-k; i >= 0; i--){
            sum = sums[i];
            if(i != nums.length-k)
                third[i] = sum >= sums[third[i+1]] ? i : third[i+1];
            else
                third[i] = nums.length-k;
        }

        int[] result = {0, 0, 0};
        int max = 0;
        for(int i = k; i < nums.length-2*k+1; i++){
            int temp = sums[first[i-k]]+sums[i]+sums[third[i+k]];
            if(temp > max) {
                max = temp;
                result[0] = first[i-k];
                result[1] = i;
                result[2] = third[i+k];
            }

        }

        return result;
    }

    public static void main(String[] args){
        No689 no689 = new No689();
        int[] nums = {7,13,20,19,19,2,10,1,1,19};
        int k = 3;
        System.out.print(no689.maxSumOfThreeSubarrays(nums, k));
    }
}
