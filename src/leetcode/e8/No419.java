package leetcode.e8;

/**
 * Created by txwyy123 on 18/7/10.
 */
public class No419 {

    public int countBattleships(char[][] board) {
        if(board == null)
            return 0;

        int count = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'X'){
                    count++;
                    int k = j;
                    while(k < board[i].length && board[i][k] == 'X') {
                        board[i][k] = '.';
                        k++;
                    }
                    k = i+1;
                    while (k < board.length && board[k][j] == 'X') {
                        board[k][j] = '.';
                        k++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        No419 no419 = new No419();
        char[][] a = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.print(no419.countBattleships(a));
    }
}
