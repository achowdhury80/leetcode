package com.leet.algo;
import java.util.*;
public class Prob1094 {
	public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        for (int i = 0; i < trips.length; i++) {
        	pq.offer(new int[] {trips[i][0], trips[i][1]});
        	pq.offer(new int[] {-trips[i][0], trips[i][2]});
        }
        int cur = 0;
        while(!pq.isEmpty()) {
        	int[] arr = pq.poll();
        	cur += arr[0];
        	if (cur > capacity) return false;
        }
        return true;
    }
}
