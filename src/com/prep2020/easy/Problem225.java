package com.prep2020.easy;
import java.util.*;
public class Problem225 {
	private Queue<Integer> emptyQ, nonEmptyQ;
	/** Initialize your data structure here. */
    public Problem225() {
    	emptyQ = new LinkedList<>();
    	nonEmptyQ = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        nonEmptyQ.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	moveNonEmptyToEmpty();
        int val = emptyQ.poll();
        return val;
    }
    
    /** Get the top element. */
    public int top() {
        moveNonEmptyToEmpty();
        int val = emptyQ.peek();
        nonEmptyQ.offer(emptyQ.poll());
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return emptyQ.isEmpty() && nonEmptyQ.isEmpty();
    }
    
    private void moveNonEmptyToEmpty() {
    	while(nonEmptyQ.size() > 1) emptyQ.offer(nonEmptyQ.poll());
    	Queue<Integer> temp = emptyQ;
    	emptyQ = nonEmptyQ;
    	nonEmptyQ = temp;
    }
}
