package leetcode;

/**
 * Created by txwyy123 on 18/7/2.
 */
public class No20 {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty())
            return true;

        char[] stack = new char[s.length()];
        int top = -1;
        int index = 0;

        do{
            char c = s.charAt(index);
            if(top == -1 || !isMatch(stack[top], c)){
                top++;
                stack[top] = c;
            } else{
                top--;
            }
            index++;
        }while (index < s.length());

        return top == -1;
    }

    private boolean isMatch(char l, char r){
        return (l == '(' && r == ')')
                || (l == '[' && r == ']')
                || (l == '{' && r == '}');
    }

    public static void main(String[] args){
        No20 no20 = new No20();
        String s = "([)]";
        System.out.print(no20.isValid(s));
    }
}
