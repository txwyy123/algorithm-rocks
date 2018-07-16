package leetcode.e13;

/**
 * Created by txwyy123 on 18/7/16.
 */
public class No326 {

    public boolean isPowerOfThree(int n) {
        while(n != 0){
            if(n == 1)
                return true;
            if(n % 3 == 0)
                n = n/3;
            else
                return false;
        }

        return false;
    }
}
