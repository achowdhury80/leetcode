package com.prep2020.medium;
import java.util.*;
public class Problem1353 {
	public int maxEvents(int[][] events) {
        Arrays.sort(events, (x, y) -> x[0] - y[0]);
        Queue<Integer> pq = new PriorityQueue<>();
        int result = 0, i = 0;
        for (int d = 1; d < 100001; d++) {
        	while(i < events.length && events[i][0] == d) {
        		pq.offer(events[i][1]);
        		i++;
        	}
        	
        	while(!pq.isEmpty() && pq.peek() < d) pq.poll();
        	if (!pq.isEmpty()) {
        		result++;
        		pq.poll();
        	}
        }
        return result;
    }
}
