package leetcode.e51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/8/26.
 */
public class No6 {

    public String convert(String s, int numRows) {
        String result = "";
        int count = s.length();
        List<String> list = new ArrayList<>();

        int i = 0;
        int row = 0;
        boolean up = true;
        while(i < count){
            String str;
            str = row == list.size() ? "" : list.get(row);
            str += s.charAt(i);

            if(row == list.size())
                list.add(str);
            else
                list.set(row, str);

            row = up ? row+1 : row-1;
            if(row == numRows-1)
                up = false;
            if(row == 0)
                up = true;
            i++;
        }

        for(String str : list)
            result += str;

        return result;
    }

    public static void main(String[] args){
        No6 no6 = new No6();
        String s = "PAYPALISHIRING";
        int row = 1;
        System.out.print(no6.convert(s, row));
    }
}
