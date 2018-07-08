package leetcode.c1;

/**
 * Created by txwyy123 on 18/7/8.
 */
public class No1 {

    public int[][] transpose(int[][] A) {
        if(A == null || A.length == 0)
            return A;

        int[][] result = new int[A[0].length][A.length];
        for(int i = 0; i < A[0].length; i++){
            for(int j = 0; j < A.length; j++){
                result[i][j] = A[j][i];
            }
        }

        return result;
    }
}
