package leetcode.e36;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by txwyy123 on 18/8/10.
 */
public class No224 {

    public int calculate(String s) {
        if(s == null || s.isEmpty())
            return 0;

        List<String> suffixExp = new ArrayList<>();
        Stack<Character> stack = new Stack();
        String num = "";
        for(char c : s.toCharArray()){
            if('(' == c ){
                stack.push(c);
                if(!"".equals(num)){
                    suffixExp.add(num);
                    num = "";
                }
            }else if('+' == c || '-' == c){
                if(!"".equals(num)){
                    suffixExp.add(num);
                    num = "";
                }
                while(!stack.isEmpty()) {
                    char ch = stack.peek();
                    if (ch == '+' || ch == '-') {
                        suffixExp.add(stack.pop()+"");
                    }else
                        break;
                }
                stack.push(c);
            }else if(c-'0' >= 0 && c-'0' <= 9){
                num += c;
            }else if(')' == c){
                if(!"".equals(num)){
                    suffixExp.add(num);
                    num = "";
                }
                char ch = stack.pop();
                while(ch != '('){
                    suffixExp.add(ch+"");
                    ch = stack.pop();
                }
            }
        }

        if(!"".equals(num))
            suffixExp.add(num);
        while (!stack.isEmpty()){
            suffixExp.add(stack.pop()+"");
        }

        Stack<Integer> res = new Stack<>();
        for(String str : suffixExp){
            if("+".equals(str)){
                Integer second = res.pop();
                Integer first = res.pop();
                res.push(first+second);
            }else if("-".equals(str)){
                Integer second = res.pop();
                Integer first = res.pop();
                res.push(first-second);
            }else{
                res.push(Integer.valueOf(str));
            }
        }

        return res.pop();
    }

    public static void main(String[] args){
        No224 no224 = new No224();
        System.out.print(no224.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
