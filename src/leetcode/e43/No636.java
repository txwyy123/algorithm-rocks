package leetcode.e43;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by txwyy123 on 18/8/18.
 */
public class No636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if(n <= 0)
            return result;

        Stack<String> stack = new Stack<>();
        for(String log : logs){
            if(stack.isEmpty()){
                stack.push(log);
            }else{
                String[] logArray = log.split(":");
                if(logArray[1].equals("end")){
                    int innerTime = 0;
                    String l = stack.pop();
                    String[] lArray = l.split(":");
                    while(!lArray[1].equals("start")){
                        innerTime += Integer.valueOf(lArray[2]);
                        l = stack.pop();
                        lArray = l.split(":");
                    }
                    int time = Integer.valueOf(logArray[2])-Integer.valueOf(lArray[2])+1-innerTime;
                    result[Integer.valueOf(lArray[0])] += time;
                    stack.push(lArray[0]+":"+"last"+":"+(time+innerTime));
                }else{
                    stack.push(log);
                }
            }
        }

        return result;
    }

    public int[] exclusiveTime1(int n, List<String> logs) {
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        int prev = 0;

        for(String log : logs){
            String[] parts = log.split(":");

            if(!stack.isEmpty())
                res[stack.peek()] += Integer.parseInt(parts[2]) - prev;

            prev = Integer.parseInt(parts[2]);

            if(parts[1].equals("start"))
                stack.push(Integer.parseInt(parts[0]));
            else{
                res[stack.pop()]++;
                prev++;
            }
        }

        return res;
    }

    public static void main(String[] args){
        No636 no636 = new No636();
        int n = 2;
        List<String> logs = Arrays.asList("0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5");
        no636.exclusiveTime1(n, logs);
    }
}

