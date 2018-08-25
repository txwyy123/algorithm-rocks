package leetcode.e50;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/25.
 */
public class No785 {

    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0)
            return false;

        int[] colors = new int[graph.length];
        int[] visited = new int[graph.length];
        List<Integer> list = new ArrayList<>();

        for(int j = 0; j < graph.length; j++) {
            if(visited[j] == 0){
                list.add(j);
            }

            while (!list.isEmpty()) {
                Integer node = list.get(0);
                list.remove(0);

                if (visited[node] == 2)
                    continue;

                Integer color = colors[node] == 0 ? 1 : 0;
                for (int i = 0; i < graph[node].length; i++) {
                    if (visited[graph[node][i]] == 2) {
                        continue;
                    } else if (visited[graph[node][i]] == 1) {
                        if (colors[graph[node][i]] == colors[node])
                            return false;
                        list.add(graph[node][i]);
                    } else {
                        colors[graph[node][i]] = color;
                        visited[graph[node][i]] = 1;
                        list.add(graph[node][i]);
                    }
                }
                visited[node] = 2;
            }
        }

        return true;
    }

    public static void main(String[] args){
        No785 no785 = new No785();
        int[][] a = {{}, {3}, {}, {1}, {}};
        System.out.print(no785.isBipartite(a));
    }
}
