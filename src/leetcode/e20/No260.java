package leetcode.e20;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by txwyy123 on 18/7/28.
 */
public class No260 {

    public int[] singleNumber(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.contains(nums[i])){
                map.add(nums[i]);
            }else{
                map.remove(nums[i]);
            }
        }

        int[] result = new int[map.size()];
        Iterator<Integer> iterator = map.iterator();
        for(int i = 0; i < result.length; i++)
            result[i] = iterator.next();
        return result;
    }

    public static void main(String[] args){
        No260 no260 = new No260();
        int[] a = {1,2,1,3,2,5};
        System.out.print(no260.singleNumber(a));
    }
}
