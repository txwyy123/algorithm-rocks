package leetcode.e43;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/20.
 */
public class No670 {

    public int maximumSwap(int num) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        int n = num;
        while(n != 0){
            list.add(0, n%10);
            n /= 10;
        }

        for(int i = 0; i < list.size(); i++){
            int digit = list.get(i);
            if(digit != 9){
                int max = digit;
                int index = i;
                for(int j = i+1; j < list.size(); j++){
                    if(list.get(j) >= max && list.get(j) != list.get(i)){
                        max = list.get(j);
                        index = j;
                    }
                }

                if(index != i) {
                    Collections.swap(list, i, index);
                    for (int j = list.size() - 1; j >= 0; j--) {
                        result = (int) (list.get(j) * Math.pow(10, list.size()-1-j) + result);
                }
                    return result;
                }
            }
        }

        return num;
    }

    public static void main(String[] args){
        No670 no670 = new No670();
        System.out.print(no670.maximumSwap(1993));
    }
}
