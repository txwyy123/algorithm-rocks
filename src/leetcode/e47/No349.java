package leetcode.e47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by txwyy123 on 18/8/22.
 */
public class No349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int len = Math.min(nums1.length, nums2.length);
        int[] result = new int[len];
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int index = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j])
                j++;
            else if(nums1[i] < nums2[j])
                i++;
            else{
                if(index == 0 || result[index-1] != nums1[i]){
                    result[index] = nums1[i];
                    index++;
                }
                i++;
                j++;
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }

    public static void main(String[] args){
        No349 no349 = new No349();
        int[] num1 = {4,9,5};
        int[] num2 = {9,4,9,8,4};
        int[] result = no349.intersection(num1, num2);
        System.out.print(result);
    }
}
