package leetcode.e43;

import java.util.List;

/**
 * Created by txwyy123 on 18/8/18.
 */
public class MyCircularQueue {

    private int lIndex;
    private int index;
    private Integer[] array;
    private int count;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.lIndex = 0;
        this.index = -1;
        this.array = new Integer[k];
        this.count = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count == array.length)
            return false;
        index = (index+1)%array.length;
        array[index] = value;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count == 0)
            return false;

        array[lIndex] = null;
        lIndex = (lIndex+1)%array.length;
        count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return array[lIndex] == null ? -1 : array[lIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return array[index] == null ? -1 : array[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == array.length;
    }

    public static void main(String[] args){
        MyCircularQueue obj = new MyCircularQueue(3);
         boolean param_1 = obj.enQueue(2);
//         boolean param_2 = obj.deQueue();
         int param_3 = obj.Front();
         int param_4 = obj.Rear();
         boolean param_5 = obj.isEmpty();
         boolean param_6 = obj.isFull();
        System.out.print(param_1);
//        System.out.print(param_2);
        System.out.print(param_3);
        System.out.print(param_4);
        System.out.print(param_5);
        System.out.print(param_6);
    }
}
