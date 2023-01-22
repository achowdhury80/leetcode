package com.prep2020.medium;
import java.util.*;
public class Problem77 {
	/**
	 * O(NCK)
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		helper(n, 1, k, new ArrayList<>(), result);
		return result;
    }
	
	private void helper(int n, int start, int k, List<Integer> cur, 
			List<List<Integer>> result) {
		if (k == 0) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = start; i + k - 1 <= n; i++) {
			cur.add(i);
			helper(n, i + 1, k - 1, cur, result);
			cur.remove(cur.size() - 1);
		}
	}
}
