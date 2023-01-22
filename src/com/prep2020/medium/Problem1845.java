package com.prep2020.medium;
import java.util.*;
public class Problem1845 {
	private Queue<Integer> pq;
	private boolean[] reserved;
	public Problem1845(int n) {
		reserved = new boolean[n + 1];
		pq = new PriorityQueue<>();
		pq.offer(1);
    }
    
    public int reserve() {
        int seat = pq.poll();
        reserved[seat] = true;
        if (seat < reserved.length - 1 && !reserved[seat + 1] && (pq.isEmpty() || pq.peek() != seat + 1)) pq.offer(seat + 1);
        return seat;
    }
    
    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
        reserved[seatNumber] = false;
    }
}
