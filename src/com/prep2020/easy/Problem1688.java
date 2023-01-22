package com.prep2020.easy;

public class Problem1688 {
	/**
	 * O(logN) time and space
	 * @param n
	 * @return
	 */
	public int numberOfMatches(int n) {
        if (n == 1) return 0;
        if (n % 2 == 0) return (n / 2) + numberOfMatches(n / 2);
        return (n / 2) + numberOfMatches(n / 2 + 1);
    }
}
