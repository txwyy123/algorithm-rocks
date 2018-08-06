package leetcode.e32;

/**
 * Created by txwyy123 on 18/8/6.
 */
public class No204 {

    public int countPrimes(int n) {
        if(n < 3)
            return 0;

        if(n < 4)
            return 1;

        boolean[] notPrime = new boolean[n-2];
        for(int i = 2; i < (n+1)/2; i++){
            if(!notPrime[i-2]){
                for(int j = 2; j*i-2 < n-2; j++){
                    notPrime[j*i-2] = true;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < notPrime.length; i++){
            if(!notPrime[i])
                count++;
        }
        return count;
    }

    public static void main(String[] args){
        No204 no204 = new No204();
        System.out.print(no204.countPrimes(5));
    }
}
