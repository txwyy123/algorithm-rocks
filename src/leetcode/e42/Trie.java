package leetcode.e42;

/**
 * Created by txwyy123 on 18/8/16.
 */
public class Trie {

    class TrieNode{
        TrieNode[] nodes;
        boolean isStr;

        TrieNode(boolean isStr){
            this.isStr = isStr;
            this.nodes = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode(false);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.isEmpty())
            return;

        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode node = cur.nodes[c-'a'];
            if(node == null){
                node = new TrieNode(false);
                cur.nodes[c-'a'] = node;
            }
            cur = node;
        }

        cur.isStr = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.isEmpty())
            return false;

        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode node = cur.nodes[c-'a'];
            if(node == null)
                return false;
            cur = node;
        }

        return cur.isStr;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.isEmpty())
            return false;

        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            TrieNode node = cur.nodes[c-'a'];
            if(node == null)
                return false;
            cur = node;
        }

        return true;
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
