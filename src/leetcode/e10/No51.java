package leetcode.e10;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/12.
 */
public class No51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n <= 0)
            return result;

        boolean[][] visited = new boolean[n][n];
        doFind(n, visited, 0, new ArrayList<String>(), result);
        return result;
    }

    private void doFind(int n, boolean[][] visited, int index, List<String> temp, List<List<String>> result){
        if(temp.size() == n){
            result.add(temp);
            return;
        }

        for(int j = 0; j < n; j++){
            if(!visited[index][j]){
                boolean[][] copy = new boolean[n][n];
                for(int row = 0; row < n; row++)
                    System.arraycopy(visited[row], 0, copy[row], 0, n);
                put(copy, n, index, j);
                List<String> tempCopy = new ArrayList<>(temp);
                tempCopy.add(genStr(n, j));
                doFind(n, copy, index+1, tempCopy, result);
            }
        }
    }

    private void put(boolean[][] visited, int n, int i, int j){
        for(int m = 0; m < n; m++) {
            visited[i][m] = true;
            visited[m][j] = true;

            if(i-m >= 0 && j-m >= 0)
                visited[i-m][j-m] = true;
            if(i-m >= 0 && j+m < n)
                visited[i-m][j+m] = true;
            if(i+m < n && j-m >= 0)
                visited[i+m][j-m] = true;
            if(i+m < n && j+m < n)
                visited[i+m][j+m] = true;
        }
    }

    private String genStr(int n, int index){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i == index)
                builder.append('Q');
            else
                builder.append('.');
        }
        return builder.toString();
    }

    public static void main(String[] args){
        No51 no51 = new No51();
        System.out.print(no51.solveNQueens(4));
    }
}
