package leetcode.e54;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/28.
 */
public class No20 {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty())
            return true;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(c == ')' || c == '}' || c == ']'){
                if(stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            }else
                stack.push(c);
            i++;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args){
        No20 no20 = new No20();
        String s = "}";
        System.out.print(no20.isValid(s));
    }
}
