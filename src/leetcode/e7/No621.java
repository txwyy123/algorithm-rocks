package leetcode.e7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/9.
 */
public class No621 {

    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;

        int[] map = new int[26];
        for(int i = 0; i < tasks.length; i++){
            map[tasks[i]-'A']++;
        }
        Arrays.sort(map);

        int time = 0;
        while(map[25] > 0){
            int i = 0;
            while(i <= n){
                if(map[25] == 0){
                    break;
                }
                if(i < 26 && map[25-i] > 0){
                    map[25-i]--;
                }
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
}
