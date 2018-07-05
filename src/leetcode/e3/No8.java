package leetcode.e3;

/**
 * Created by txwyy123 on 18/7/5.
 */
public class No8 {

    public int myAtoi(String str) {
        if(str == null || str.isEmpty())
            return 0;

        long result = 0;
        int index = 0;
        boolean isBlank = true;
        boolean isOperator = true;
        boolean isPostive = true;
        String num = "";
        while(index < str.length()){
            if (str.charAt(index) == ' ' && isBlank) {
                index++;
                continue;
            }
            isBlank = false;

            if(str.charAt(index) == '-' && isOperator){
                isPostive = false;
                isOperator = false;
                index++;
                continue;
            }else if(str.charAt(index) == '+' && isOperator){
                isOperator = false;
                index++;
                continue;
            }else if(str.charAt(index) >= '0' && str.charAt(index) <= '9' && isOperator){
                num += Character.toString(str.charAt(index));
                isOperator = false;
                index++;
                continue;
            }else if(isOperator){
                return 0;
            }

            if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
                num += Character.toString(str.charAt(index));
            }else{
                break;
            }

            index++;
        }

        for(int i = 0; i < num.length(); i++){
            result += (num.charAt(num.length()-1-i)-'0')*Math.pow(10, i);
        }

        if(!isPostive)
            result = -result;

        if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) result;
    }

    public static void main(String[] args){
        No8 no8 = new No8();
        String s = "-91283472332";
        System.out.print(no8.myAtoi(s));
    }
}
