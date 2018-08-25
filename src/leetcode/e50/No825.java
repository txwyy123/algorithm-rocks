package leetcode.e50;

/**
 * Created by txwyy123 on 18/8/25.
 */
public class No825 {

    public int numFriendRequests(int[] ages) {
        int result = 0;
        if(ages == null || ages.length == 0)
            return result;

        int[] array = new int[120];
        for(int age : ages)
            array[age-1]++;

        for(int age : ages){
            int min = (int) (0.5*age+7);
            int max = age;
            if(age < 100)
                max = Math.min(max, 100);

            for(int a = min+1; a <= max; a++)
                result += array[a-1];

            if(age > min && age <= max)
                result--;
        }

        return result;
    }
}
