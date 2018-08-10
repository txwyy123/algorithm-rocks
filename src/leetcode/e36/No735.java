package leetcode.e36;

/**
 * Created by txwyy123 on 18/8/10.
 */
public class No735 {

    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length <= 1)
            return asteroids;

        int len = asteroids.length;
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] < 0){
                for(int j = i-1; j >= 0; j--){
                    if(asteroids[j] > 0) {
                        if (asteroids[i] + asteroids[j] < 0) {
                            asteroids[j] = 0;
                            len--;
                        } else if (asteroids[i] + asteroids[j] == 0) {
                            asteroids[j] = 0;
                            asteroids[i] = 0;
                            len -= 2;
                            break;
                        } else {
                            asteroids[i] = 0;
                            len--;
                            break;
                        }
                    }
                }
            }
        }

        int[] result = new int[len];
        for(int i = 0, j = 0; i < asteroids.length; i++) {
            if(asteroids[i] != 0) {
                result[j] = asteroids[i];
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args){
        No735 no735 = new No735();
        int[] a = {10,2,-5};
        no735.asteroidCollision(a);
    }
}
