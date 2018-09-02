package leetcode.e57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by txwyy123 on 18/9/2.
 */
public class No126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(!wordList.contains(endWord))
            return result;

        List<String> wList = new ArrayList<>(wordList);
        if(!wList.contains(beginWord))
            wList.add(0, beginWord);
        int[][] map = new int[wList.size()][wList.size()];
        for(int i = 0; i < wList.size(); i++){
            for(int j = i+1; j < wList.size(); j++){
                if(isSimilar(wList.get(i), wList.get(j))) {
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }

        List<List<Integer>> stack = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        int min = wList.size()+1;
        start.add(wList.indexOf(beginWord));
        stack.add(start);
        while(!stack.isEmpty()){
            List<Integer> path = stack.remove(stack.size()-1);
            Integer node = path.get(path.size()-1);
            if(wList.get(node).equals(endWord)) {
                if(path.size() < min){
                    result.clear();
                    min = path.size();
                }else if(path.size() > min)
                    continue;
                List<String> res = new ArrayList<>();
                for(Integer i : path)
                    res.add(wList.get(i));
                result.add(res);
            }else{
                for(int i = 0; i < map[node].length; i++){
                    if(map[node][i] == 1 && path.size() < min) {
                        List<Integer> newPath = new ArrayList<>(path);
                        newPath.add(i);
                        stack.add(newPath);
                    }
                }
            }
        }


        return result;
    }

    boolean isSimilar(String s1, String s2){
        boolean isDiff = false;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i) && !isDiff)
                isDiff = true;
            else if(s1.charAt(i) != s2.charAt(i) && isDiff)
                return false;
        }
        return isDiff;
    }

    public static void main(String[] args){
        No126 no126 = new No126();
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dog","dot");
        System.out.print(no126.findLadders(beginWord, endWord, wordList));
    }
}
