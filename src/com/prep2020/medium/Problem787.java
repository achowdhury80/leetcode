package com.prep2020.medium;
import java.util.*;
public class Problem787 {
	public int findCheapestPrice(int n, int[][] flights, int src, 
			int dst, int k) {
        int[][] dis = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j <= k + 1; j++) dis[i][j] = Integer.MAX_VALUE;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
        	Map<Integer, Integer> mp  = map.getOrDefault(f[0], 
        			new HashMap<>());
        	mp.put(f[1], f[2]);
        	map.put(f[0], mp);
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[2] == y[2] 
        		? (x[1] - y[1]) : (x[2] - y[2])));
        pq.offer(new int[] {src, 0, 0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (dis[cur[0]][cur[1]] <= cur[2]) continue;
        	dis[cur[0]][cur[1]] = cur[2];
        	if (cur[0] == dst) return cur[2];
        	if (cur[1] > k) continue;
        	if (!map.containsKey(cur[0])) continue;
        	for (Map.Entry<Integer, Integer> entry 
        			: map.get(cur[0]).entrySet()) {
        		pq.offer(new int[] {entry.getKey(), cur[1] + 1, 
        				cur[2] + entry.getValue()});
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem787 problem = new Problem787();
		System.out.println(problem.findCheapestPrice(3, null, 0, 2, 1));
	}
}
