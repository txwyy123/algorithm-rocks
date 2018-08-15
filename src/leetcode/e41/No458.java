package leetcode.e41;

/**
 * Created by txwyy123 on 18/8/15.
 */
public class No458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int base = minutesToTest/minutesToDie;
        return (int) Math.ceil(Math.log(buckets)/Math.log(base+1));
    }
}
