package leetcode.e18;

/**
 * Created by txwyy123 on 18/7/25.
 */
public class No289 {

    public void gameOfLife(int[][] board) {
        if(board == null)
            return;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                change(board, i, j);
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 2)
                    board[i][j] = 1;
                if(board[i][j] == 3)
                    board[i][j] = 0;
            }
        }
    }

    private void change(int[][] board, int i, int j){
        int countOfLive = 0;
        int countOfDeath = 0;

        if(i-1 >= 0){
            if(j-1 >= 0) {
                if(isLive(board, i-1, j-1))
                    countOfLive++;
            }

            if(isLive(board, i-1, j))
                countOfLive++;

            if(j+1 < board[0].length){
                if(isLive(board, i-1, j+1))
                    countOfLive++;
            }
        }

        if(j-1 >= 0){
            if(isLive(board, i, j-1))
                countOfLive++;
        }

        if(j+1 < board[0].length){
            if(isLive(board, i, j+1))
                countOfLive++;
        }

        if(i+1 < board.length){
            if(j-1 >= 0) {
                if(isLive(board, i+1, j-1))
                    countOfLive++;
            }

            if(isLive(board, i+1, j))
                countOfLive++;

            if(j+1 < board[0].length){
                if(isLive(board, i+1, j+1))
                    countOfLive++;
            }
        }

        if(isLive(board, i, j)){
            if(countOfLive < 2 || countOfLive > 3)
                board[i][j] = 3;
        }else{
            if(countOfLive == 3)
                board[i][j] = 2;
        }
    }

    private boolean isLive(int[][] board, int i, int j){
        if(board[i][j] == 0 || board[i][j] == 2)
            return false;
        return true;
    }

    public static void main(String[] args){
        No289 no289 = new No289();
        int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        no289.gameOfLife(a);
    }
}
