package leetcode.e50;

/**
 * Created by txwyy123 on 18/8/24.
 */
public class No215 {

    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return 0;

        int index;
        int l = 0;
        int r = nums.length-1;
        do{
            index = partition(nums, l, r);
            if(index == k-1)
                break;
            else if(index > k-1){
                r = index-1;
            }else{
                l = index+1;
            }
        }while(true);

        return nums[k-1];
    }

    int partition(int[] nums, int l, int r){
        if(l >= r)
            return l;

        int k = nums[r];
        int i = l;
        int j = r;
        while(i < j){
            while(nums[i] >= k && i < j)
                i++;
            while(nums[j] <= k && i < j)
                j--;
            swap(nums, i, j);
        }

        swap(nums, i, r);
        return i;
    }

    void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args){
        No215 no215 = new No215();
        int[] a = {5,2,4,1,3,6,0};
        int k = 2;
        System.out.print(no215.findKthLargest(a, k));
    }
}
