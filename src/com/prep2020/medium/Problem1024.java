package com.prep2020.medium;
import java.util.*;
public class Problem1024 {
	/**
	 * O(nlogn) time and o(n) space
	 * @param clips
	 * @param time
	 * @return
	 */
	public int videoStitching(int[][] clips, int time) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> 
        	(x[0] == y[0]) ? (y[1] - x[1]) : (x[0] - y[0]));
        for (int[] clip : clips) pq.offer(clip);
        int last = 0, result = 0;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[0] > last) return -1;
        	if (cur[1] <= last) continue;
        	if (cur[0] < last) {
        		cur[0] = last;
        		pq.offer(cur);
        	} else {
        		result++;
        		last = cur[1];
        		if (last >= time) break;
        	}
        }
        if (last < time) return -1;
        return result;
    }
}
