package com.prep2020.medium;

public class Problem526 {
	/**
	 * O(K) where k refers to number of valid permutations
	 * @param n
	 * @return
	 */
	public int countArrangement(int n) {
        int[] result = new int[1];
        helper(n, 0, 0, result);
        return result[0];
    }
	
	private void helper(int n, int used, int permSize, int[] result) {
		if (permSize == n) {
			result[0]++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (((used >> i) & 1) > 0) continue;
			if (i % (permSize + 1) == 0 || (permSize + 1) % i == 0) {
				helper(n, used | (1 << i), permSize + 1, result);
			}
		}
	}
}
