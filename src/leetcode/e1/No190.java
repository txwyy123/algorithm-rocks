package leetcode.e1;

/**
 * Created by txwyy123 on 18/7/3.
 */
public class No190 {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = ((result << 1) | ((n >> i) & 1));
        }
        return result;
    }

    public static void main(String[] args) {
        No190 no190 = new No190();
        System.out.print(no190.reverseBits(123));
    }
}
