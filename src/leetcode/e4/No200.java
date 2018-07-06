package leetcode.e4;

/**
 * Created by txwyy123 on 18/7/6.
 */
public class No200 {

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1')
                    doChange(grid, i, j, '2');
            }
        }

        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '2')
                    result++;
            }
        }

        return result;
    }

    private void doChange(char[][] grid, int i, int j, char c){
        if(i >= grid.length || i < 0 || j >= grid[i].length  || j < 0)
            return;

        if(grid[i][j] == '1') {
            grid[i][j] = c;
            doChange(grid, i + 1, j, (char) (c + 1));
            doChange(grid, i, j + 1, (char) (c + 1));
            doChange(grid, i-1, j, (char) (c + 1));
            doChange(grid, i, j-1, (char) (c + 1));
        }
    }

    public static void main(String[] args){
        No200 no200 = new No200();
        char[][] a = {{'1','1','1'}, {'0','1','0'}, {'1','1','1'}};
        System.out.print(no200.numIslands(a));
    }
}
