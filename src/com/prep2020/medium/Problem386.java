package com.prep2020.medium;
import java.util.*;
public class Problem386 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			if (i <= n) {
				result.add(i);
				helper(i, result, n);
			}
		}
		return result;
    }
	
	private void helper(int num, List<Integer> result, int n) {
		if (num * 10 > n) return;
		for (int i = 0; i < 10; i++) {
			int temp = num * 10 + i;
			if (temp <= n) {
				result.add(temp);
				helper(temp, result, n);
			} else break;
		}
	}
}
