package com.prep2020.easy;
import java.util.*;
public class Problem155 {
	private Deque<Integer> stack, minStack;
	public Problem155() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack.offerLast(x);
        if (minStack.isEmpty() || minStack.peekLast() >= x) minStack.offerLast(x);
    }
    
    public void pop() {
        int val = stack.pollLast();
        if (val == minStack.peekLast()) minStack.pollLast();
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}
