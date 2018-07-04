package leetcode.e2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/7/4.
 */
public class No22 {

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        doGenerate(n, 0, "", set);
        return new ArrayList<>(set);
    }

    private void doGenerate(int n, int index, String temp, Set<String> result) {
        if (index >= n) {
            result.add(temp);
            return;
        }

        for (int i = 0; i <= temp.length() / 2; i++) {
            String copy = temp.substring(0, i) + "()" + temp.substring(i);
            doGenerate(n, index + 1, copy, result);
        }
    }

    public static void main(String[] args){
        No22 no22 = new No22();
        System.out.print(no22.generateParenthesis(3));
    }
}
