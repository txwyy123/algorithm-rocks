package leetcode.e52;

/**
 * Created by txwyy123 on 18/8/27.
 */
public class No88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || n == 0)
            return;

        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while(index >= 0){
            Integer first = i >= 0 ? nums1[i] : null;
            Integer second = j >= 0 ? nums2[j] : null;

            if(first == null){
                nums1[index] = second;
                j--;
            }else if(second == null){
                nums1[index] = first;
                i--;
            }else{
                if(first > second) {
                    nums1[index] = first;
                    i--;
                } else {
                    nums1[index] = second;
                    j--;
                }
            }
            index--;
        }
    }

    public static void main(String[] args){
        No88 no88 = new No88();
        int[] a1 = {1,2,3,0,0,0};
        int[] a2 = {2,5,6};
        int m = 3;
        int n = 3;
        no88.merge(a1, m, a2, n);
    }
}
