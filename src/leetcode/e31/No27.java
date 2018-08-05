package leetcode.e31;

/**
 * Created by txwyy123 on 18/8/4.
 */
public class No27 {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)
            return 0;

        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args){
        No27 no27 = new No27();
        int[] a = {0,1,2,2,3,0,4,2};
        System.out.print(no27.removeElement(a, 2));
    }
}
