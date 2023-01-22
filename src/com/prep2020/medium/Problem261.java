package com.prep2020.medium;
import java.util.*;
public class Problem261 {
	/**
	 * O(N +E) time and O(N) space
	 * @param n
	 * @param edges
	 * @return
	 */
	public boolean validTree(int n, int[][] edges) {
        Set<Integer>[] nexts = new Set[n];
        for (int i = 0; i < n; i++) nexts[i] = new HashSet<>();
        for (int[] e : edges) {
        	nexts[e[0]].add(e[1]);
        	nexts[e[1]].add(e[0]);
        }
        int[] count = new int[1];
        if (!helper(0, -1, nexts, new int[n], count)) return false;
        return count[0] == n;
    }

	private boolean helper(int cur, int parent, Set<Integer>[] nexts, int[] color, int[] count) {
		if (color[cur] == 2) return true;
		if (color[cur] == 1) return false;
		color[cur] = 1;
		for (int next : nexts[cur]) {
			if (next == parent) continue;
			if (!helper(next, cur, nexts, color, count)) return false;
		}
		color[cur] = 2;
		count[0]++;
		return true;
	}
}
