package leetcode.e17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/24.
 */
public class No93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.isEmpty() || s.length() > 12)
            return result;

        doRestore(s, 0, 0, "", result);
        return result;
    }

    private void doRestore(String s, int index, int count, String temp, List<String> result){
        if(count == 4 && index == s.length()) {
            result.add(temp);
            return;
        }

        for(int i = index; i < index+3 && i < s.length(); i++){
            String sub = s.substring(index, i+1);
            Integer subInt = Integer.valueOf(sub);
            if((subInt == 0 && sub.equals("0")) || (!sub.startsWith("0") && subInt > 0 && subInt <= 255)) {
                String tempCopy = new String(temp);
                tempCopy = tempCopy.isEmpty() ? sub : tempCopy + "." + sub;
                doRestore(s, i+1, count+1, tempCopy, result);
            }
        }
    }

    public static void main(String[] args){
        No93 no93 = new No93();
        System.out.print(no93.restoreIpAddresses("010010"));
    }
}
