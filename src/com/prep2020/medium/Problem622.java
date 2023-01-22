package com.prep2020.medium;
import java.util.*;
public class Problem622 {
	private List<Integer> list;
	private int n;
	public Problem622(int k) {
        list = new ArrayList<>();
        this.n = k;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        list.add(value);
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;
        list.remove(0);
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return list.get(0);
    }
    
    public int Rear() {
    	if (isEmpty()) return -1;
        return list.get(list.size() - 1);
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean isFull() {
        return list.size() == n;
    }
}
