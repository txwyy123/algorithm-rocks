package leetcode.e8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/7/11.
 */
public class No212 {

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if(board == null || words == null)
            return new ArrayList<>(result);

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(String word : words) {
            outter:
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (doFind(board, word, isVisited, i, j, 0)) {
                        result.add(word);
                        break outter;
                    }
                }
            }
        }
        return new ArrayList<>(result);
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
        No212 no212 = new No212();
        char[][] a = {{'a'}};
        String[] words = {"a", "a"};
        no212.findWords(a, words);
    }

}
