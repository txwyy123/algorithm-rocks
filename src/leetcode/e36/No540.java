package leetcode.e36;

/**
 * Created by txwyy123 on 18/8/10.
 */
public class No540 {

    public int singleNonDuplicate(int[] nums) {
        // binary search
        int n=nums.length, lo=0, hi=n/2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2*m]!=nums[2*m+1]) hi = m;
            else lo = m+1;
        }
        return nums[2*lo];
    }

    public static void main(String[] args){
        No540 no540 = new No540();
        int[] a = {1,1,2,3,3,4,4};
        System.out.print(no540.singleNonDuplicate(a));
    }
}
