package leetcode.e37;

/**
 * Created by txwyy123 on 18/8/11.
 */
public class No498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null)
            return null;
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int[] result = new int[matrix.length*matrix[0].length];
        int direction = 0;
        int i = 0;
        int j = 0;
        int index = 0;
        while(index < result.length){
            result[index] = matrix[i][j];
            if(direction == 0) {
                i--;
                j++;
                if(i < 0 && j < matrix[0].length){
                    i = 0;
                    direction = 1;
                }else if(j >= matrix[0].length){
                    i = i+2;
                    j = matrix[0].length-1;
                    direction = 1;
                }
            }else{
                i++;
                j--;
                if(i < matrix.length && j < 0){
                    j = 0;
                    direction = 0;
                }else if(i >= matrix.length){
                    i = matrix.length-1;
                    j = j+2;
                    direction = 0;
                }
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args){
        No498 no498 = new No498();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = no498.findDiagonalOrder(a);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}
