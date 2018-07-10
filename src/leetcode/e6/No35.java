package leetcode.e6;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No35 {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        if(target < nums[0])
            return 0;
        if(target > nums[nums.length-1])
            return nums.length;

        int l = 0, r = nums.length-1;
        int mid = (l+r)/2;

        while(l < r){
            if(target == nums[mid])
                return mid;
            if(target < nums[mid]){
                r = mid;
                mid = (l+r)/2;
            }else{
                l = mid+1;
                mid = (l+r)/2;
            }
        }

        return l;
    }

    public static void main(String[] args){
        No35 no35 = new No35();
        int[] a = {1,3,5,6};
        int t = 7;
        System.out.print(no35.searchInsert(a, t));
    }
}
