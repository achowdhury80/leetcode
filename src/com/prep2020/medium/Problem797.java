package com.prep2020.medium;
import java.util.*;
public class Problem797 {
	/**
	 * dfs
	 * O(N)
	 * @param graph
	 * @return
	 */
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		cur.add(0);
		helper(graph, 0, graph.length - 1, cur, result);
		return result;
    }
	
	private void helper(int[][] graph, int start, int target, List<Integer> cur, 
			List<List<Integer>> result) {
		if (start == target) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int node : graph[start]) {
			cur.add(node);
			helper(graph, node, target, cur, result);
			cur.remove(cur.size() - 1);
		}
	}
}
