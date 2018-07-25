package leetcode.e18;

/**
 * Created by txwyy123 on 18/7/25.
 */
public class No240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length || j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                if(i == matrix.length-1)
                    return false;
                i++;
            } else {
                if(j == 0)
                    return false;
                j--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        No240 no240 = new No240();
        int[][] a = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.print(no240.searchMatrix(a, 20));
    }
}
