package com.prep2020.easy;

public class Problem172 {
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
        if (n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}
