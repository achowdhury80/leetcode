package com.prep2020.medium;
import java.util.*;
public class Problem1557 {
	/**
	 * O(N)
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		List<Integer> result = new ArrayList<>();
		boolean[] reachable = new boolean[n];
		for (List<Integer> edge : edges) reachable[edge.get(1)] = true;
		for (int i = 0; i < n; i++) 
			if (!reachable[i]) result.add(i);
		return result;
    }
}
