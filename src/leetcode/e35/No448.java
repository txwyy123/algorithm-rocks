package leetcode.e35;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/9.
 */
public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] ns = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(ns[nums[i]-1] == 0){
                ns[nums[i]-1] = nums[i];
            }
        }

        for(int i = 0; i < ns.length; i++){
            if(ns[i] == 0){
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args){
        No448 no448 = new No448();
        int[] a = {4,3,2,7,8,2,3,1};
        System.out.print(no448.findDisappearedNumbers(a));
    }
}
