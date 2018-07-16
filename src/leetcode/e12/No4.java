package leetcode.e12;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return 0;

        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;
        int i = (start+end)/2;
        int j = (m+n+1)/2-i;

        while(start <= end){
            if((i > 0 && i < m && j > 0 && j < n && nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i])
                    || m == 0
                    || (i == 0 && nums2[j-1] <= nums1[i])
                    || (i == nums1.length && nums1[i-1] <= nums2[j])) {
                break;
            }else if(i > 0 && nums1[i-1] > nums2[j]){
                end = i;
            }else{
                start = i+1;
            }
            i = (start+end)/2;
            j = (m+n+1)/2-i;
        }

        if((m+n) % 2 == 0){
            double a,b,c,d;
            a = i == 0 ? Integer.MIN_VALUE : nums1[i-1];
            b = i == nums1.length ? Integer.MAX_VALUE : nums1[i];
            c = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            d = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
            return (Math.max(a, c) + Math.min(b, d))/2;
        }else{
            double a, b;
            a = i == 0 || m == 0 ? Integer.MIN_VALUE : nums1[i-1];
            b = j == 0 ? Integer.MIN_VALUE : nums2[j-1];
            return Math.max(a, b);
        }

    }

    public static void main(String[] args){
        No4 no4 = new No4();
        int[] num1 = {};
        int[] num2 = {2,3};
        System.out.print(no4.findMedianSortedArrays(num1, num2));
    }
}
