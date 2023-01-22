package com.prep2020.medium;

public class Problem1718 {
	/**
	 * O(n!)
	 * @param n
	 * @return
	 */
	public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        solve(0, 0, n, result);
        return result;
    }

	private boolean solve(int start, int used, int max, int[] result) {
		if (start == result.length) return true;
		if (result[start] != 0) return solve(start + 1, used, max, result);
		for (int i = max; i > 0; i--) {
			if ((used & (1 << i)) > 0) continue;
			if (i == 1) {
				result[start] = i;
				if (solve(start + 1, used | (1 << i), max, result)) return true;
				result[start] = 0;
			} else {
			if (start + i >= result.length || result[start + i] != 0) continue;
				result[start] = i;
				result[start + i] = i;
				if (solve(start + 1, used | (1 << i), max, result)) return true;
				result[start] = 0;
				result[start + i] = 0;
			}
		}
		return false;
	}
}
