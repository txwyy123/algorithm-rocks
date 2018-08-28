package leetcode.e51;

/**
 * Created by txwyy123 on 18/8/27.
 */
public class No689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxsum = 0;
        int[] sum = new int[n+1], posLeft = new int[n], posRight = new int[n], ans = new int[3];
        for (int i = 0; i < n; i++) sum[i+1] = sum[i]+nums[i];
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1]-sum[i+1-k];
            }
            else
                posLeft[i] = posLeft[i-1];
        }
        // DP for starting index of the right max sum interval
        // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }
            else
                posRight[i] = posRight[i+1];
        }
        // test all possible middle interval
        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-k], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }

    public int[] maxSumOfThreeSubarrays1(int[] nums, int k) {
        //W is an array of sums of windows
        int[] W = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i-k];
            if (i >= k-1) W[i-k+1] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int[] ans = new int[]{-1, -1, -1};
        for (int j = k; j < W.length - k; j++) {
            int i = left[j - k], m = right[j + k];
            if (ans[0] == -1 || W[i] + W[j] + W[m] >
                    W[ans[0]] + W[ans[1]] + W[ans[2]]) {

                ans[0] = i;
                ans[1] = j;
                ans[2] = m;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        No689 no689 = new No689();
        int[] a = {1,2,1,2,6,7,5,1};
        int k = 2;
        System.out.print(no689.maxSumOfThreeSubarrays1(a, k));
    }
}
