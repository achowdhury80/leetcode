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
		int[] visited = new int[n];
		return dfs(source, map, visited, destination);
    }
	
	private boolean dfs(int node, Map<Integer, Set<Integer>> map, int[] visited, 
			int dst) {
		if (visited[node] == 1) return false; 
		if (node == dst) return true;
		visited[node] = 1;
		Set<Integer> nexts = map.get(node);
		if (nexts == null) return false;
		for (int next : nexts) {
			if (visited[next] == 2) continue;
			if (!dfs(next, map, visited, dst)) return false;
		}
		visited[node] = 2;
		return true;
	}
}
