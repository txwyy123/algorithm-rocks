package leetcode.e39;

/**
 * Created by txwyy123 on 18/8/13.
 */
public class No374 {

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        int num = l+(r-l)/2;
        do{
            if(guess(num) < 0){
                r = num;
            }else if(guess(num) == 0){
                return num;
            }else{
                l = num+1;
            }
            num = l+(r-l)/2;
        }while(guess(num) != 0);

        return num;
    }

    private int guess(int num){
        return 0;
    }
}
