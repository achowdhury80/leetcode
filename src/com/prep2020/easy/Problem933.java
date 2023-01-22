package com.prep2020.easy;
import java.util.*;
public class Problem933 {
	private Deque<Integer> dq;
	public Problem933() {
        dq = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        dq.offerLast(t);
        while(dq.peekFirst() < t - 3000) dq.pollFirst();
        return dq.size();
    }
}
