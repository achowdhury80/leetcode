package com.leet.algo;
import java.util.*;
public class Prob1059 {
	/**
	 * BFS - with cycle detection O(m + n)
	 * @param n
	 * @param edges
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
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
	
	private boolean dfs(int node, Map<Integer, Set<Integer>> map, int[] visited, int destination) {
		if (visited[node] == 1) return false; // cycle
		if (node == destination) return true;
		visited[node] = 1; //grey - in progress
		if (map.get(node) == null) return false;
		for (int next : map.get(node)) {
			if(visited[next] == 2) continue;
			if (!dfs(next, map, visited, destination)) return false;
		}
		visited[node] = 2;
		return true;
	}
	
	public static void main(String[] args) {
		Prob1059 prob = new Prob1059();
		System.out.println(prob.leadsToDestination(4, new int[][] {{0,1},{0,2},{1,3},{2,3}}, 0, 3));
	}
}
