package leetcode.e44;

import java.util.*;

/**
 * Created by txwyy123 on 18/8/20.
 */
public class No336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if(words == null || words.length == 0)
            return result;

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
            map.put(words[i], i);

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int l = 0, r = 0;
            while(l <= r){
                String sub = word.substring(l, r);
                Integer j = map.get(new StringBuilder(sub).reverse().toString());
                if(j != null && i != j && isPalin(word.substring(l == 0 ? r : 0, l == 0 ? word.length() : l))) {
                    if(l == 0)
                        result.add(Arrays.asList(i, j));
                    else
                        result.add(Arrays.asList(j, i));
                }

                if(r < word.length())
                    r++;
                else
                    l++;
            }
        }

        return result;
    }

    boolean isPalin(String s){
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }

    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) addWord(root, words[i], i);
        for (int i = 0; i < words.length; i++) search(words, i, root, res);

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) root.next[j] = new TrieNode();
            if (isPalindrome(word, 0, i)) root.list.add(index);
            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args){
        No336 no336 = new No336();
        String[] words = {"abcd","dcba","lls","s","sssll"};
        System.out.print(no336.palindromePairs1(words));
    }
}
