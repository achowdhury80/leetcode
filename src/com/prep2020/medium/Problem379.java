package com.prep2020.medium;

import java.util.*;

public class Problem379 {
	boolean[] used;
	Queue<Integer> q = new PriorityQueue<Integer>();
	 /** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public Problem379(int maxNumbers) {
	    used = new boolean[maxNumbers];
	    if (maxNumbers > 0) q.offer(0);
	}
	
	/** Provide a number which is not assigned to anyone.
	    @return - Return an available number. Return -1 if none is available. */
	public int get() {
	    if (q.isEmpty()) return -1;
	    int idx = q.poll();
	    while(!q.isEmpty() && idx == q.peek()) q.poll();
	    used[idx] = true;
	    if(idx < used.length - 1 && !used[idx + 1]) q.offer(idx + 1);
	    return idx;
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number) {
	    return !used[number];
	}
	
	/** Recycle or release a number. */
	public void release(int number) {
	    used[number] = false;
	    q.offer(number);
	}
}
