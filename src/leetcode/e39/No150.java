package leetcode.e39;

import java.util.Stack;

/**
 * Created by txwyy123 on 18/8/13.
 */
public class No150 {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < tokens.length){
            String str = tokens[i];
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")){
                stack.push(Integer.valueOf(str));
            }else{
                Integer second = stack.pop();
                Integer first = stack.pop();
                switch (str){
                    case "+":
                        stack.push(first+second);break;
                    case "-":
                        stack.push(first-second);break;
                    case "*":
                        stack.push(first*second);break;
                    case "/":
                        stack.push(first/second);break;
                }
            }
            i++;
        }

        return stack.pop();
    }

    public static void main(String[] args){
        No150 no150 = new No150();
        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.print(no150.evalRPN(strs));
    }
}
