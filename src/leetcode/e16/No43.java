package leetcode.e16;

import leetcode.e7.No3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/22.
 */
public class No43 {

    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
            return null;

        String result = "";
        List<String> tempList = new ArrayList<>();
        for(int i = num1.length()-1; i >= 0; i--){
            int carry = 0;
            String temp = "";
            int j = num2.length()-1;
            for(; j >= 0; j--){
                int t = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                temp = (t+carry)%10 + temp;
                carry = (t+carry)/10;
            }
            temp = carry > 0 ? carry + temp : temp;
            temp = temp.charAt(0) == '0' ? "0" : temp;

            for(int m = 0; m < num1.length()-1-i && !temp.equals("0"); m++){
                temp += "0";
            }

            tempList.add(temp);
        }

        for(String t : tempList) {
            if(result.isEmpty()) {
                result = t;
            } else {
                String r = "";
                String a = result.length() >= t.length() ? result : t;
                String b = result.length() < t.length() ? result : t;
                int carry = 0;
                for(int i = b.length()-1; i >= 0; i--){
                    int temp = (a.charAt(i+a.length()-b.length())-'0')+(b.charAt(i)-'0')+carry;
                    if(temp >= 10){
                        carry = 1;
                        temp -= 10;
                    }else{
                        carry = 0;
                    }
                    r = temp+r;
                }

                for(int i = a.length()-b.length()-1; i >= 0; i--){
                    int temp = (a.charAt(i)-'0')+carry;
                    if(temp >= 10){
                        carry = 1;
                        temp -= 10;
                    }else{
                        carry = 0;
                    }
                    r = temp+r;
                }
                r = carry > 0 ? carry+r : r;

                result = r;
            }

        }

        return result;
    }

    public static void main(String[] args){
        No43 no43 = new No43();
        String s1 = "0";
        String s2 = "42";
        System.out.print(no43.multiply(s1, s2));
    }
}
