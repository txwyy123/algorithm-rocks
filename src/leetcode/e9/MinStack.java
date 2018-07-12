package leetcode.e9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txwyy123 on 18/7/11.
 */
public class MinStack {

    private List<Integer> stack;
    private List<Integer> minList;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<>();
        this.minList = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        if(minList.isEmpty() || x <= minList.get(minList.size()-1))
            minList.add(x);
    }

    public void pop() {
        int x = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        if(x == minList.get(minList.size()-1))
            minList.remove(minList.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }
}
