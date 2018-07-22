package leetcode.e16;

/**
 * Created by txwyy123 on 18/7/22.
 */
public class No134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0)
            return -1;


        for(int i = 0; i < gas.length; i++){
            int origin = 0;
            if(gas[i] >= cost[i]){
                int j = i;
                int now = 0;
                do {
                    now = origin+gas[j]-cost[j];
                    if(now < 0) {
                        i = j > i ? j : i;
                        break;
                    } else{
                        j = (j+1)%gas.length;
                        origin = now;
                    }

                    if(j == i)
                        return i;
                }while (j != i);
            }
        }

        return -1;
    }

    public static void main(String[] args){
        No134 no134 = new No134();
        int[] gas = {4,5,2,6,5,2};
        int[] cost = {3,2,7,3,2,9};
        System.out.print(no134.canCompleteCircuit(gas, cost));
    }
}
