package leetcode.e8;

/**
 * Created by txwyy123 on 18/7/10.
 */
public class No79 {

    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            return false;

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(doFind(board, word, isVisited, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean doFind(char[][] board, String word, boolean[][] isVisited, int i, int j, int index){
        if(index >= word.length())
            return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[i].length
                || (!word.isEmpty() && board[i][j] != word.charAt(index)))
            return false;

        boolean result = false;
        if(!isVisited[i][j] && word.charAt(index) == board[i][j]){
            isVisited[i][j] = true;
            int ind = index+1;
            result = doFind(board, word, isVisited, i+1, j, ind)
                    || doFind(board, word, isVisited, i-1, j, ind)
                    || doFind(board, word, isVisited, i, j+1, ind)
                    || doFind(board, word, isVisited, i, j-1, ind);
            isVisited[i][j] = false;
        }else{
            result = false;
        }

        return result;
    }

    public static void main(String[] args){
        No79 no79 = new No79();
        char[][] board = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        System.out.print(no79.exist(board, "ABCB"));
    }
}
