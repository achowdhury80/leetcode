package com.prep2020.hard;
import java.util.*;
public class Problem753 {
	/**
	 * O(K^N)
	 * @param n
	 * @param k
	 * @return
	 */
	public String crackSafe(int n, int k) {
		int total = 1;
		StringBuilder sb = new StringBuilder();
		/*
         * total variation = k^n
         * in the result string, first one use n chars, then later ones uses
         * previous n-1 char plus one new char
         * so total should be n + (k^n - 1)
         * computing total
         */
		for (int i = 0; i < n; i++) {
			total *= k;
			sb.append("0");
		}
		total += n - 1;
		Set<String> visited = new HashSet<>();
		String s = sb.toString();
		visited.add(s);
		return dfs(n, k, total, s, visited);
    }

	private String dfs(int n, int k, int total, String cur, Set<String> visited) {
		String prefix = cur.substring(cur.length() - n + 1);
		for (int i = 0; i < k; i++) {
			String next = prefix + i;
			if (visited.contains(next)) continue;
			visited.add(next);
			String temp = dfs(n, k, total, cur + i, visited);
			if (temp.length() == total) return temp;
			visited.remove(next);
		}
		return cur;
	}
}
