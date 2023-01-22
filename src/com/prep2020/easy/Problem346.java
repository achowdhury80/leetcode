package com.prep2020.easy;
import java.util.*;
public class Problem346 {
	/** Initialize your data structure here. */
	private Deque<Integer> dq;
	private int size, sum;
    public Problem346(int size) {
        this.size = size;
        sum = 0;
        dq = new ArrayDeque<>();
    }
    
    public double next(int val) {
    	if (dq.size() == size) {
    		sum -= dq.pollFirst();
    	}
    	dq.offerLast(val);
    	sum += val;
    	return (sum + 0.0) / dq.size();
    }
}
