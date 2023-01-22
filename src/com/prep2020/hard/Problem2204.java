package com.prep2020.hard;
import java.util.*;
public class Problem2204 {
	public int[] distanceToCycle(int n, int[][] edges) {
		Map<Integer, List<Integer>> nextMap = new HashMap<>();
		for (int[] e : edges) {
			List<Integer> list = nextMap.getOrDefault(e[0], new ArrayList<>());
			list.add(e[1]);
			nextMap.put(e[0], list);
			list = nextMap.getOrDefault(e[1], new ArrayList<>());
			list.add(e[0]);
			nextMap.put(e[1], list);
		}
        Set<Integer> cycleSet = new HashSet<>();
		findCycle(0, -1, nextMap, new boolean[n], cycleSet);
		int[] result = new int[n];
		for (int i = 0; i < n; i++) result[i] = Integer.MAX_VALUE;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int node : cycleSet) {
        	pq.offer(new int[] {node, 0});
        }
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[1] >= result[cur[0]]) continue;
        	result[cur[0]] = cur[1];
        	for (int next : nextMap.get(cur[0])) {
        		pq.offer(new int[] {next, cur[1] + 1});
        	}
        }
        return result;
    }
	
	private int findCycle(int cur, int prev, Map<Integer, List<Integer>> nextMap, boolean[] visited, Set<Integer> cycleSet) {
		if (visited[cur]) return cur;
		visited[cur] = true;
		List<Integer> nexts = nextMap.get(cur);
		for (int next : nexts) {
			if (next == prev) continue;
			int cycleStartPoint = findCycle(next, cur, nextMap, visited, cycleSet);
			if(cycleStartPoint > -1) cycleSet.add(cur);
			if(cycleStartPoint != -1)
				//-2 means the next vertex is the starting/ending vertext of the cycle
                return cycleStartPoint == cur? -2: cycleStartPoint;
			
		}
		return -1;
	}
}
