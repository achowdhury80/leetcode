package com.prep2020.easy;
import java.util.*;
public class Problem1971 {
	/**
	 * O(N)
	 * @param n
	 * @param edges
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
        	Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
        	set.add(edge[1]);
        	map.put(edge[0], set);
        	set = map.getOrDefault(edge[1], new HashSet<>());
        	set.add(edge[0]);
        	map.put(edge[1], set);
        }
        boolean[] visited = new boolean[n];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
        	int node = q.poll();
        	if (map.containsKey(node)) {
        		for (int next : map.get(node)) {
        			if (next == end) return true;
        			if (visited[next]) continue;
        			visited[next] = true;
        			q.offer(next);
        		}
        	}
        }
        return false;
    }
}
