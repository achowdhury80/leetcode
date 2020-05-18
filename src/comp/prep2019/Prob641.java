package comp.prep2019;

import java.util.*;

public class Prob641 {
	private int size;
	private List<Integer> list;
	/** Initialize your data structure here. Set the size of the deque to be k. */
    public Prob641(int k) {
        size = k;
        list = new ArrayList<>();
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        list.add(0, value);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if (isFull()) return false;
        list.add(value);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	if (isEmpty()) return false;
    	list.remove(0);
    	return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if (isEmpty()) return false;
    	list.remove(list.size() - 1);
    	return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if (isEmpty()) return -1;
        return list.get(0);
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return list.get(list.size() - 1);
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return list.size() == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return list.size() == size;
    }
}
