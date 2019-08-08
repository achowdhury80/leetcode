package com.leet.algo;
import java.util.*;
public class Prob901 {
	private Stack<int[]> stack;
	public Prob901() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!stack.isEmpty() && price >= stack.peek()[0]) {
        	count += stack.pop()[1];
        }
        stack.push(new int[] {price, count});
        return count;
    }
}
