package leetcode.e5;

import java.util.*;

/**
 * Created by txwyy123 on 18/7/7.
 */
public class No401 {

    public List<String> readBinaryWatch(int num) {
        Set<String> result = new HashSet<>();

        for(int i = 0; i <= Math.min(num, 4); i++){
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            doPermute(i, 4, 0, 0, hours);
            doPermute(num-i, 6, 0, 0, minutes);
            for(Integer hour : hours){
                for(Integer minute : minutes){
                    if(minute <= 59 && hour <= 11) {
                        if (minute >= 10) {
                            result.add(hour + ":" + minute);
                        } else {
                            result.add(hour + ":" + "0" + minute);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void doPermute(int num, int total, int index, Integer temp, List<Integer> result){
        if(num <= 0){
            result.add(temp);
            return;
        }

        for(int i = index; i < total; i++){
            Integer copy = temp;
            copy = copy + (int)Math.pow(2, i);
            doPermute(num-1, total, i+1, copy, result);
        }
    }

    public static void main(String[] args){
        No401 no401 = new No401();
        System.out.print(no401.readBinaryWatch(2));
    }
}
