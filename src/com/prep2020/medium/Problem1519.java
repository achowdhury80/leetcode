package com.prep2020.medium;
import java.util.*;
public class Problem1519 {
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] result = new int[n];
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        for (int[] e : edges) {
        	Set<Integer> set = nexts.getOrDefault(e[0], new HashSet<>());
        	set.add(e[1]);
        	nexts.put(e[0], set);
        	set = nexts.getOrDefault(e[1], new HashSet<>());
        	set.add(e[0]);
        	nexts.put(e[1], set);
        }
        countLabels(0, nexts, new boolean[n], result, labels);
        return result;
    }
	
	private int[] countLabels(int node, Map<Integer, Set<Integer>> nexts, boolean[] used, int[] result, String labels) {
		int[] counts = new int[26];
		counts[labels.charAt(node) - 'a'] = 1;
		used[node] = true;
		for (int next : nexts.get(node)) {
			if (used[next]) continue;
			int[] subTreeCounts = countLabels(next, nexts, used, result, labels);
			for (int i = 0; i < 26; i++) counts[i] += subTreeCounts[i];
		}
		result[node] = counts[labels.charAt(node) - 'a'];
		return counts;
	}
}
