package com.prep2020.medium;
import java.util.*;
public class Problem362 {
	private Deque<Integer> dq;
	/** Initialize your data structure here. */
    public Problem362() {
        dq = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        dq.offerLast(timestamp);
        removeHitsBefore5Minutes(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	removeHitsBefore5Minutes(timestamp);
    	return dq.size();
    }
    
    private void removeHitsBefore5Minutes(int timestamp) {
    	if (timestamp < 301) return;
    	int minAllowed = timestamp - 299;
    	while(!dq.isEmpty() && dq.peekFirst() < minAllowed) dq.pollFirst();
    }
}
