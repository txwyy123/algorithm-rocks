package leetcode.e12;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No463 {

    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int perimeter = 4;
                    if(i > 0 && grid[i-1][j] == 1)
                        perimeter--;
                    if(j > 0 && grid[i][j-1] == 1)
                        perimeter--;
                    if(i < grid.length-1 && grid[i+1][j] == 1)
                        perimeter--;
                    if(j < grid[i].length-1 && grid[i][j+1] == 1)
                        perimeter--;
                    result += perimeter;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        No463 no463 = new No463();
        int[][] a = {{1},{0}};
        System.out.print(no463.islandPerimeter(a));
    }
}
