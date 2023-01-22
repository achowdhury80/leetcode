package com.prep2020.medium;
import java.util.*;

public class Problem1245 {
	/**
	 * O(N)
	 * @param edges
	 * @return
	 */
	public int treeDiameter(int[][] edges) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] e : edges) {
			Arrays.sort(e);
			List<Integer> list = map.getOrDefault(e[0], new ArrayList<>());
			list.add(e[1]);
			map.put(e[0], list);
		}
		int[] result = new int[1];
		findLongestPaths(map, 0, result);
		return result[0];
    }
	
	private Integer findLongestPaths(Map<Integer, List<Integer>> map, int root, int[] result) {
		if (!map.containsKey(root)) {
			return 0;
		}
		List<Integer> maxTwoPaths = new ArrayList<>();
		for (int next : map.get(root)) {
			Integer pathLen = 1 + findLongestPaths(map, next, result);
			maxTwoPaths.add(pathLen);
			Collections.sort(maxTwoPaths);
			if (maxTwoPaths.size() == 3) maxTwoPaths.remove(0);
		}
		if (maxTwoPaths.size() == 1) result[0] = Math.max(result[0], maxTwoPaths.get(0));
		else result[0] = Math.max(result[0], maxTwoPaths.get(0) + maxTwoPaths.get(1));
		return maxTwoPaths.get(maxTwoPaths.size() - 1);
	}
}
