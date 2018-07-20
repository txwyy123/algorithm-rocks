package leetcode.e15;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/19.
 */
public class No310 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] matrix = new int[n][n];
        for(int i = 0; i < edges.length; i++){
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = 1;
        }

        int min = Integer.MAX_VALUE;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            boolean[] visited = new boolean[n];
            int height = getHeight(i, matrix, visited);
            if(height < min){
                min = height;
                result.clear();
                result.add(i);
            }else if(height == min){
                result.add(i);
            }
        }

        return result;
    }

    private int getHeight(int node, int[][] matrix, boolean[] visited){
        int height = 0;
        visited[node] = true;
        for(int i = 0; i < matrix[node].length; i++){
            if(!visited[i] && matrix[node][i] == 1){
                visited[i] = true;
                int temp = getHeight(i, matrix, visited);

                if(temp > height)
                    height = temp;
            }
        }

        return height+1;
    }

    public static void main(String[] args){
        No310 no310 = new No310();
        int[][] a = {{0,3},{1,3},{2,3},{4,3},{5,4}};
        System.out.print(no310.findMinHeightTrees(6, a));
    }
}
