package leetcode.e3;

/**
 * Created by txwyy123 on 18/7/5.
 */
public class No73 {

    public void setZeroes(int[][] matrix) {
        if(matrix == null)
            return;

        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args){
        No73 no73 = new No73();
        int[][] a = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        no73.setZeroes(a);
    }
}
