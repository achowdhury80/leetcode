package com.leet.algo;
import java.util.*;
public class Prob716 {
	private Stack<int[]> stack;
	private PriorityQueue<int[]> pq;
	private int id;
	public Prob716() {
		stack = new Stack<>();
        pq = new PriorityQueue<>((x, y) -> (y[1] - x[1] == 0 ? y[0] - x[0] : y[1] - x[1]));
        id = 0;
    }
    
    public void push(int x) {
    	id++;
    	int[] data = new int[]{id, x};
        stack.push(data);
        pq.offer(data);
    }
    
    public int pop() {
        int[] x;
        while((x = stack.pop())[0] < 0);
        x[0] = -x[0];
        return x[1];
    }
    
    public int top() {
    	int[] x;
        while((x = stack.pop())[0] < 0) ;
        stack.push(x);
        return x[1];
    }
    
    public int peekMax() {
        int[] x;
        while((x = pq.poll())[0] < 0);
        pq.offer(x);
        return x[1];
    }
    
    public int popMax() {
    	int[] x;
        while((x = pq.poll())[0] < 0) ;
        x[0] = -x[0];
        return x[1];
    }
    
    public static void main(String[] args) {
    	Prob716 prob = new Prob716();
    	prob.push(5);
    	prob.push(1);
    	prob.push(5);
    	System.out.println(prob.top());
    	System.out.println(prob.popMax());
    	System.out.println(prob.top());
    }
}
