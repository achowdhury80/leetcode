package com.prep2020.hard;
import java.util.*;
public class Problem2246 {
	public int longestPath(int[] parent, String s) {
		int n = parent.length;
		Map<Integer, List<Integer>> nextMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (parent[i] != -1) {
				List<Integer> nexts = nextMap.getOrDefault(parent[i], new ArrayList<>());
				nexts.add(i);
				nextMap.put(parent[i], nexts);
			}
		}
		int[] result = new int[] {1};
		findLongestPath(0, nextMap, result, s.toCharArray());
		return result[0];
    }

	private int findLongestPath(int node, Map<Integer, List<Integer>> nextMap, int[] result, char[] arr) {
		if (!nextMap.containsKey(node)) return 1;
		Queue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
		for (int next : nextMap.get(node)) {
			int pathLength = findLongestPath(next, nextMap, result, arr);
			if (arr[node] == arr[next]) continue;
			pq.offer(pathLength);
			if (pq.size() > 2) pq.poll();
		}
		if (pq.isEmpty()) return 1;
		if (pq.size() == 1) {
			int pathLength = 1 + pq.poll();
			result[0] = Math.max(result[0], pathLength);
			return pathLength;
		}
		int secondMax = pq.poll(), max = pq.poll();
		result[0] = Math.max(result[0], 1 + secondMax + max);
		return 1 + max;
	}
}
