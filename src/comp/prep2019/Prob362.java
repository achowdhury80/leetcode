package comp.prep2019;
import java.util.*;
public class Prob362 {
	private Deque<Integer> dq;
	 /** Initialize your data structure here. */
    public Prob362() {
        dq = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        dq.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	while(!dq.isEmpty() && dq.peekFirst() <= timestamp - 300) dq.removeFirst();
        return dq.size();
    }
}
