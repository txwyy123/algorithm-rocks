package leetcode.e10;

import java.util.Stack;

/**
 * Created by txwyy123 on 18/7/12.
 */
public class MyQueue {

    Stack<Integer> first;
    Stack<Integer> second;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        first.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = 0;
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        result = second.isEmpty() ? 0 : second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = 0;
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        result = second.isEmpty() ? 0 : second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return first.isEmpty();
    }
}
