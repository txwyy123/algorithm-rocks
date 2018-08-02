package leetcode.e30;

/**
 * Created by txwyy123 on 18/8/2.
 */
public class No306 {

    public boolean isAdditiveNumber(String num) {
        if(num == null || num.isEmpty() || num.length() < 3)
            return false;

        for(int i = 1; i < num.length(); i++){
            for(int j = i+1; j < num.length(); j++){
                if(doJudge(num, j, num.substring(0, i), num.substring(i, j)))
                    return true;
            }
        }
        return false;
    }

    private boolean doJudge(String num, int index, String first, String second){
        if(index >= num.length())
            return true;

        for(int i = index+1; i < num.length()+1; i++){
            String third = num.substring(index, i);
            if((first.startsWith("0") && first.length() > 1)
                    || (second.startsWith("0") && second.length() > 1)
                    || (third.startsWith("0") && third.length() > 1))
                return false;
            if(Long.valueOf(first)+Long.valueOf(second) == Long.valueOf(third)){
                if(doJudge(num, i, second, third))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        No306 no306 = new No306();
        System.out.print(no306.isAdditiveNumber("8019823962"));
    }
}
