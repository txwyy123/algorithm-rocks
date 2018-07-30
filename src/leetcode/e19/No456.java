package leetcode.e19;

import java.util.Stack;
import java.util.TreeMap;

/**
 * Created by txwyy123 on 18/7/26.
 */
public class No456 {

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        Stack<Integer> stack = new Stack<>();
        int s3 = Integer.MIN_VALUE;
        for(int i = nums.length-1; i >= 0; i--){
            int s1 = nums[i];
            if(s1 < s3)
                return true;

            int max = Integer.MIN_VALUE;
            while(!stack.isEmpty() && stack.peek() < s1) {
                max = Math.max(max, stack.pop());
            }
            s3 = max == Integer.MIN_VALUE ? s3 : max;

            stack.push(s1);

        }

        return false;
    }

    public static void main(String[] args){
        No456 no456 = new No456();
        int[] a = {-2,1,2,-2,1,2};
        System.out.print(no456.find132pattern(a));
    }
}
