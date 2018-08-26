package leetcode.e51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by txwyy123 on 18/8/26.
 */
public class No433 {

    public int minMutation(String start, String end, String[] bank) {
        int result = Integer.MAX_VALUE;
        boolean hasEnd = false;
        int[][] graph = new int[bank.length][bank.length];
        for(int i = 0; i < bank.length; i++){
            if(bank[i].equals(end))
                hasEnd = true;
            for(int j = i+1; j < bank.length; j++){
                if(canMutate(bank[i], bank[j])){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }

        if(!hasEnd)
            return -1;

        for(int i = 0; i < bank.length; i++){
            if(canMutate(start, bank[i])){
                int count = doMutate(end, bank, i, graph);
                if(count < result && count != -1)
                    result = count;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    boolean canMutate(String s1, String s2){
        boolean isDiff = false;
        for(int i = 0; i < 8; i++){
            if(s1.charAt(i) != s2.charAt(i) && !isDiff){
                isDiff = true;
            }else if(s1.charAt(i) != s2.charAt(i) && isDiff){
                return false;
            }
        }
        return true;
    }

    int doMutate(String end, String[] bank, int index, int[][] graph){
        List<Integer> list = new ArrayList<>();
        list.add(index);
        int result = 1;
        Set<Integer> visited = new HashSet<>();
        visited.add(index);

        while(!list.isEmpty()){
            int size = list.size();
            for(int k = 0; k < size; k++) {
                int s = list.remove(0);
                String str = bank[s];
                if (str.equals(end))
                    return result;

                for(int j = 0; j < graph[s].length; j++){
                    if(graph[s][j] == 1 && !visited.contains(j)){
                        list.add(j);
                        visited.add(j);
                    }
                }
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args){
        No433 no433 = new No433();
        String start = "AAAAACCC";
        String end = "AACCCCCC";
        String[] bank = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};
        System.out.print(no433.minMutation(start, end, bank));
    }
}