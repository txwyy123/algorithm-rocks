package leetcode.e54;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/8/28.
 */
public class No22 {

    public List<String> generateParenthesis(int n) {
        Set<String> result = new HashSet<>();
        if(n <= 0)
            return new ArrayList<>(result);

        if(n == 1) {
            result.add("()");
            return new ArrayList<>(result);
        }

        List<String> list = generateParenthesis(n-1);
        for(String str : list){
            for(int i = 0; i<= str.length(); i++){
                StringBuilder builder = new StringBuilder();
                builder.append(str.substring(0, i))
                        .append("()")
                        .append(str.substring(i));
                result.add(builder.toString());
            }
        }

        return new ArrayList<>(result);
    }
}
