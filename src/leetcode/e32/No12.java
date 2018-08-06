package leetcode.e32;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by txwyy123 on 18/8/6.
 */
public class No12 {

    public String intToRoman(int num) {
        Map<Integer, String> map = new LinkedHashMap<Integer, String>(){{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        StringBuilder result = new StringBuilder();
        Iterator<Integer> iterator = map.keySet().iterator();
        while(num != 0){
            Integer operator = 0;
            while(iterator.hasNext()){
                operator = iterator.next();
                if(num >= operator){
                    break;
                }
            }

            while(num >= operator){
                num -= operator;
                result.append(map.get(operator));
            }
        }

        return result.toString();
    }

    public static void main(String[] args){
        No12 no12 = new No12();
        System.out.print(no12.intToRoman(1994));
    }
}
