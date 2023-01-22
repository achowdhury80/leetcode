package com.prep2020.hard;
import java.util.*;
public class Problem882 {
	public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Integer>[] nexts = new Map[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashMap<>();
        for (int[] e : edges) {
        	Map<Integer, Integer> next = nexts[e[0]];
        	next.put(e[1], e[2]);
        	next = nexts[e[1]];
        	next.put(e[0], e[2]);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        pq.offer(new int[] {0, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[1] >= dist[cur[0]]) continue;
        	dist[cur[0]] = cur[1];
        	for (Map.Entry<Integer, Integer> next : nexts[cur[0]].entrySet()) {
        		if (cur[1] + next.getValue() < maxMoves) pq.offer(new int[] {next.getKey(), cur[1] + next.getValue() + 1});
        	}
        }
        
        int result = 0;
        for (int i = 0; i < n; i++) {
        	if (dist[i] <= maxMoves) result++;
        }
        
        for (int[] e : edges) {
        	if (dist[e[0]] <= maxMoves && dist[e[1]] <= maxMoves) {
        		result += Math.min(2 * maxMoves - dist[e[0]] - dist[e[1]], e[2]);
        	} else if (dist[e[0]] < maxMoves) {
        		result += (maxMoves - dist[e[0]]);
        	} else if (dist[e[1]] < maxMoves) {
        		result += (maxMoves - dist[e[1]]);
        	}
        }
        
        return result;
        
    }
}
