package leetcode.e19;

import java.util.TreeMap;

/**
 * Created by txwyy123 on 18/7/26.
 */
public class No456 {

    public boolean find132pattern(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;

        int min = nums[0];
        int max = nums[2];
        int minIndex = 0;
        int maxIndex = 2;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 2; i < nums.length; i++)
            map.put(nums[i], i);

        for(int i = 1; i < nums.length-1; i++){
            Integer temp = map.lowerKey(nums[i]);
            max = temp == null ? max :temp;
            maxIndex = map.get(max);

            if(i > minIndex && max > min && i < maxIndex && nums[i] > max){
                return true;
            }

            if(nums[i] < min){
                minIndex = i;
                min = nums[i];
            }
        }

        return false;
    }

    public static void main(String[] args){
        No456 no456 = new No456();
        int[] a = {3,1,4,2};
        System.out.print(no456.find132pattern(a));
    }
}
