package leetcode.e8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/7/11.
 */
public class No212 {

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if(board == null || words == null)
            return new ArrayList<>(result);

        TrieNode root = buildTree(words);
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                doFind(board, root, i, j, result);
        return new ArrayList<>(result);
    }

    private void doFind(char[][] board, TrieNode p, int i, int j, Set<String> result){
        char c = board[i][j];
        if(c == '#' || p.next[c-'a'] == null)
            return;

        p = p.next[c-'a'];
        if(p.word != null){
            result.add(p.word);
        }

        board[i][j] = '#';
        if(i > 0)
            doFind(board, p, i-1, j, result);
        if(j > 0)
            doFind(board, p, i, j-1, result);
        if(i < board.length-1)
            doFind(board, p, i+1, j, result);
        if(j < board[i].length-1)
            doFind(board, p, i, j+1, result);
        board[i][j] = c;
    }

    private TrieNode buildTree(String[] words){
        TrieNode root = new TrieNode();
        for(String str : words){
            TrieNode p = root;
            for(char c : str.toCharArray()){
                TrieNode node = p.next[c-'a'];
                if(node == null)
                    p.next[c-'a'] = new TrieNode();
                p = p.next[c-'a'];
            }
            p.word = str;
        }
        return root;
    }

    public static void main(String[] args){
        No212 no212 = new No212();
        char[][] a = {{'a','b'},{'a','a'}};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        no212.findWords(a, words);
    }

}
