package com.prep2020.medium;
import java.util.*;

public class Problem1670 {
	private Deque<Integer> front, back;
	public Problem1670() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        front.offerFirst(val);
        adjust();
    }
    
    public void pushMiddle(int val) {
        if (front.size() > back.size()) back.offerFirst(front.pollLast());
        front.offerLast(val);
    }
    
    public void pushBack(int val) {
        back.offerLast(val);
        adjust();
    }
    
    public int popFront() {
        if (front.isEmpty()) return -1;
        int result = front.pollFirst();
        adjust();
        return result;
    }
    
    public int popMiddle() {
    	if (front.isEmpty()) return -1;
    	int result = front.pollLast();
    	if (front.size() < back.size()) front.offerLast(back.pollFirst());
    	return result;
    }
    
    public int popBack() {
    	if (front.isEmpty() && back.isEmpty()) return -1;
    	int result = -1;
        if (back.isEmpty()) {
        	result = front.pollLast();
        } else {
        	result = back.pollLast();
        }
        adjust();
        return result;
    }
    
    private void adjust() {
    	if (back.size() > front.size()) {
    		front.offerLast(back.pollFirst());
    	} else if (front.size() - back.size() > 1) {
    		back.offerFirst(front.pollLast());
    	}
    }
}
