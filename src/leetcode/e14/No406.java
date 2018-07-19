package leetcode.e14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/18.
 */
public class No406 {

    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)
            return people;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0] == 0 ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        for(int i = 0; i < people.length; i++){
            if(list.size() == 0){
                list.add(0, Arrays.asList(people[i][0], people[i][1]));
                continue;
            }

            if(people[i][1] > list.size())
                list.add(list.size()-1, Arrays.asList(people[i][0], people[i][1]));
            else
                list.add(people[i][1], Arrays.asList(people[i][0], people[i][1]));
        }

        int[][] result = new int[people.length][2];
        for(int i = 0; i < list.size(); i++){
            List<Integer> l = list.get(i);
            result[i][0] = l.get(0);
            result[i][1] = l.get(1);
        }
        return result;
    }

    public static void main(String[] args){
        No406 no406 = new No406();
        int[][] queue = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
        System.out.print(no406.reconstructQueue(queue));
    }
}
