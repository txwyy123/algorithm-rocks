package leetcode.e20;

import java.util.*;

/**
 * Created by txwyy123 on 18/7/30.
 */
public class No210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if(numCourses <= 0)
            return result;

        if(prerequisites == null || prerequisites.length == 0){
            for(int i = 0; i < numCourses; i++)
                result[i] = i;
            return result;
        }

        boolean[] reached = new boolean[numCourses];
        int[][] reach = new int[numCourses][numCourses];
        int[] in = new int[numCourses];
        Set<Integer> roots = new HashSet<>();
        for(int i = 0; i < numCourses; i++)
            roots.add(i);
        for(int i = 0; i < prerequisites.length; i++){
            reach[prerequisites[i][1]][prerequisites[i][0]] = 1;
            roots.remove(prerequisites[i][0]);
            in[prerequisites[i][0]]++;
        }

        if(roots.isEmpty())
            return new int[0];

        List<Integer> list = new ArrayList<>(roots);
        int index = 0;
        while(!list.isEmpty()){
            Integer node = list.remove(0);
            for(int i = 0; i < reach[node].length; i++){
                if(reach[node][i] == 1 && !reached[i]) {
                    in[i]--;
                    if(in[i] <= 0) {
                        list.add(i);
                        reached[i] = true;
                    }
                }
            }
            result[index] = node;
            index++;
        }

        if(index < numCourses)
            return new int[0];
        return result;
    }

    public static void main(String[] args){
        No210 no210 = new No210();
        int num = 3;
        int[][] pre = {{1,0},{1,2},{0,1}};
        int[] a = no210.findOrder(num, pre);
        for(int i : a)
            System.out.print(i + " ");
    }
}
