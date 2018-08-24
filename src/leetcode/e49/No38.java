package leetcode.e49;

/**
 * Created by txwyy123 on 18/8/23.
 */
public class No38 {

    public String countAndSay(int n) {
        if(n <= 0)
            return "";

        String result = "1";
        for(int i = 2; i <= n; i++){
            int count = 0;
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < result.length(); j++){
                if(j == 0){
                    count = 1;
                }else if(result.charAt(j) != result.charAt(j-1)){
                    temp.append(count).append(result.charAt(j-1));
                    count = 1;
                } else{
                    count++;
                }
            }
            temp.append(count).append(result.charAt(result.length()-1));
            result = temp.toString();
        }

        return result;
    }

    public static void main(String[] args){
        No38 no38 = new No38();
        System.out.print(no38.countAndSay(6));
    }
}
