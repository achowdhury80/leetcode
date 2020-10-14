package comp.prep2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob1059 {
	/**
	 * DFS - with cycle detection O(m + n)
	 * @param n
	 * @param edges
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean leadsToDestination(int n, int[][] edges, int source, 
			int destination) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] edge : edges) {
			Set<Integer> nodes = map.getOrDefault(edge[0], new HashSet<>());
			nodes.add(edge[1]);
			map.put(edge[0], nodes);
		}
		if(map.get(destination) != null) return false;
		return helper(source, new int[n], destination, map);
	}
	
	private boolean helper(int node, int[] dp, int dst, 
			Map<Integer, Set<Integer>> map) {
		if (dp[node] == 2) return true;
		if (dp[node] == 1) return false;
		dp[node] = 1;
		if (!map.containsKey(node)) {
			if (node == dst) {
				dp[node] = 2;
				return true;
			}
			return false;
		}
		for (int next : map.get(node)) {
			if (!helper(next, dp, dst, map)) return false;
		}
		dp[node] = 2;
		return true;
	}
}
