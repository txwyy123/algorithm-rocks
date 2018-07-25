package leetcode.e18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/25.
 */
public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        int count = matrix.length*matrix[0].length;
        for(int i = 0; i < (matrix.length+1)/2 && result.size() < count; i++){
            for(int n = i; n < matrix[0].length-i-1; n++)
                result.add(matrix[i][n]);
            for(int m = i; m < matrix.length-i-1 && result.size() < count; m++)
                result.add(matrix[m][matrix[0].length-i-1]);
            for(int n = matrix[0].length-i-1; n > i && result.size() < count; n--)
                result.add(matrix[matrix.length-i-1][n]);
            for(int m = matrix.length-i-1; m > i && result.size() < count; m--)
                result.add(matrix[m][i]);
        }

        if(result.size() < count)
            result.add(matrix[matrix.length/2][matrix[0].length/2]);

        return result;
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(no54.spiralOrder(a));
    }
}
