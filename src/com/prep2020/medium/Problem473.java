package com.prep2020.medium;

public class Problem473 {
	/**
	 * O(4^n)
	 * @param matchsticks
	 * @return
	 */
	public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int i : matchsticks) sum += i;
        if (sum % 4 != 0) return false;
        return helper(matchsticks, new int[4], 0, sum / 4);
    }

	private boolean helper(int[] matchsticks, int[] cur, int start, int len) {
		if (start == matchsticks.length) return true;
		for (int i = 0; i < 4; i++) {
			if (cur[i] + matchsticks[start] > len) continue;
			cur[i] += matchsticks[start];
			if (helper(matchsticks, cur, start + 1, len)) return true;
			cur[i] -= matchsticks[start];
		}
		return false;
	}
}
