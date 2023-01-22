package com.prep2020.medium;
import java.util.*;
public class Problem641 {
	private List<Integer> list;
	private int maxSize;
	public Problem641(int k) {
        this.list = new ArrayList<>();
        this.maxSize = k;
    }
    
    public boolean insertFront(int value) {
    	if (isFull()) return false;
        list.add(0, value);
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        list.add(value);
        return true;
    }
    
    public boolean deleteFront() {
    	if(isEmpty()) return false;
    	list.remove(0);
    	return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
       list.remove(list.size() - 1);
       return true;
    }
    
    public int getFront() {
    	if (isEmpty()) return -1;
    	return list.get(0);
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return list.get(list.size() - 1);
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public boolean isFull() {
        return list.size() == this.maxSize;
    }
}
