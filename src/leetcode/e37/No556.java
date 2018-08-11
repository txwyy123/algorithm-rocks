package leetcode.e37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/12.
 */
public class No556 {

    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        while(n != 0){
            int r = n%10;
            list.add(0, r);
            n = n/10;
        }

        for(int i = list.size()-1; i > 0; i--){
            if(list.get(i) > list.get(i-1)){
                int min = i;
                for (int j = i; j < list.size(); j++) {
                    if (list.get(j) < list.get(min) && list.get(j) > list.get(i-1))
                        min = j;
                }
                swap(list, i-1, min);

                Integer[] array = list.toArray(new Integer[0]);
                Arrays.sort(array, i, array.length);

                long result = 0;
                for(int j = 0; j < array.length; j++){
                    result += Math.pow(10, j)*array[array.length-j-1];
                }

                if(result > Integer.MAX_VALUE)
                    return -1;
                return (int) result;
            }
        }

        return -1;
    }

    void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args){
        No556 no556 = new No556();
        System.out.print(no556.nextGreaterElement(12333));
    }
}
