package com.prep2020.medium;
import java.util.*;
public class Problem1443 {
	/**
	 * O(N) time and space
	 * @param n
	 * @param edges
	 * @param hasApple
	 * @return
	 */
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			List<Integer> list = map.getOrDefault(edge[0], new ArrayList<>());
			list.add(edge[1]);
			map.put(edge[0], list);
			list = map.getOrDefault(edge[1], new ArrayList<>());
			list.add(edge[0]);
			map.put(edge[1], list);
		}
        int result = helper(0, map, new boolean[n], hasApple);
        return result == -1 ? 0 : result;
    }
	
	private int helper(int node, Map<Integer, List<Integer>> map, 
			boolean[] visited, List<Boolean> hasApple) {
		visited[node] = true;
		int result = 0;
		for (int next : map.get(node)) {
			if (!visited[next]) {
				int val = helper(next, map, visited, hasApple);
				if (val > -1) result += 2 + val;
			}
		}
		if (result == 0 && !hasApple.get(node)) return -1;
		return result;
	}
}
