package leetcode.e10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Created by txwyy123 on 18/7/12.
 */
public class No127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;

        boolean[] visited = new boolean[wordList.size()];
        int result = 1;
        List<String> queue = new ArrayList<>();
        queue.add(beginWord);

        while(!queue.isEmpty()){
            List<String> popedStrs = new ArrayList<>();
            while(!queue.isEmpty())
                popedStrs.add(queue.remove(0));
            for(String str : popedStrs) {
                for (int i = 0; i < wordList.size(); i++) {
                    if (!visited[i] && like(str, wordList.get(i))) {
                        if (wordList.get(i).equals(endWord)) {
                            result++;
                            return result;
                        }
                        queue.add(wordList.get(i));
                        visited[i] = true;
                    }
                }
            }
            popedStrs.clear();
            result++;
        }

        return 0;
    }

    private boolean like(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean isFirstDiff = false;
        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i] && !isFirstDiff){
                isFirstDiff = true;
            }else if(c1[i] != c2[i] && isFirstDiff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        No127 no127 = new No127();
        List<String> list = Arrays.asList("hot","dot","dog","lot","log","cog");
        String s1 = "hit";
        String s2 = "cog";
        System.out.print(no127.ladderLength(s1, s2, list));
    }
}
