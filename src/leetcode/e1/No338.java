package leetcode.e1;

/**
 * Created by txwyy123 on 18/7/3.
 */
public class No338 {

    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 0; i <= num; i++){
            int n = i;
            int r = 0;
            while(n != 0) {
                r += (n&1) == 1 ? 1 : 0;
                n = n>> 1;
            }
            result[i] = r;
        }
        return result;
    }

    public int[] countBits1(int num) {
        int[] ret = new int[num+1];
        ret[0] = 0;
        int pow = 1;
        for(int i = 1; i <= num; i++){
            ret[i] = i < pow ? ret[i-(pow>>1)]+1 : ret[i-pow]+1;
            if(i == pow){
                pow = pow << 1;
            }
        }
        return ret;
    }

    public static void main(String[] args){
        No338 no338 = new No338();
        System.out.print(no338.countBits1(7));
    }
}
