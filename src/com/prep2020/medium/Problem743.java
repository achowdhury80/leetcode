package com.prep2020.medium;
import java.util.*;
public class Problem743 {
	public int networkDelayTime(int[][] times, int n, int k) {
        int[] arrival = new int[n];
        for (int i = 0; i < n; i++) arrival[i] = Integer.MAX_VALUE;
        List<int[]>[] nexts = new List[n];
        for (int i = 0; i < n; i++) nexts[i] = new ArrayList<>();
        for (int[] t : times) {
        	nexts[t[0] - 1].add(new int[] {t[1] - 1, t[2]});
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[] {k - 1, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[1] >= arrival[cur[0]]) continue;
        	arrival[cur[0]] = cur[1];
        	for (int[] next : nexts[cur[0]]) 
        		pq.offer(new int[] {next[0], next[1] + cur[1]});
        }
        int result = -1;
        for (int i = 0; i < n; i++) result = Math.max(result, arrival[i]);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
