package com.prep2020.medium;
import java.util.*;
public class Problem1942 {
	public int smallestChair(int[][] times, int targetFriend) {
		Map<Integer, Integer> map = new HashMap<>();
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] == y[1]) 
        		? (x[2] - y[2]) : (x[1] - y[1]));
        for (int i = 0; i < times.length; i++) {
        	pq.offer(new int[] {i, times[i][0], 1});
        	pq.offer(new int[] {i, times[i][1], 0});
        }
        Queue<Integer> chairQ = new PriorityQueue<>();
        chairQ.offer(0);
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[2] == 0) {
        		int chair = map.remove(cur[0]);
        		chairQ.offer(chair);
        		continue;
        	}
        	int chair = chairQ.poll();
        	if (cur[0] == targetFriend) return chair;
        	map.put(cur[0], chair);
        	if (chairQ.isEmpty()) chairQ.offer(chair + 1);
        }
        return -1;
    }
}
