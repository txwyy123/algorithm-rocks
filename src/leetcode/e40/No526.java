package leetcode.e40;

/**
 * Created by txwyy123 on 18/8/14.
 */
public class No526 {

    public int countArrangement(int N) {
        return doCount(N, 1, new int[N]);
    }

    int doCount(int N, int index, int[] array){
        if(index > N){
            return 1;
        }

        int result = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0 && (index%(i+1) == 0 || (i+1)%index == 0)){
                array[i] = index;
                result += doCount(N, index+1, array);
                array[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args){
        No526 no526 = new No526();
        System.out.print(no526.countArrangement(5));
    }
}
