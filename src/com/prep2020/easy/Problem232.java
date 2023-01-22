package com.prep2020.easy;
import java.util.*;
public class Problem232 {
	private Stack<Integer> insertStack, removeStack;
	/** Initialize your data structure here. */
    public Problem232() {
    	insertStack = new Stack<>();
    	removeStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	insertStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (removeStack.isEmpty()) move();
    	return removeStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (removeStack.isEmpty()) move();
        return removeStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return insertStack.isEmpty() && removeStack.isEmpty();
    }
    
    private void move() {
    	while(!insertStack.isEmpty()) removeStack.push(insertStack.pop());
    }
}
