package com.prep2020.easy;

public class Problem276 {
	/**
	 * O(N)
	 * @param n
	 * @param k
	 * @return
	 */
	public int numWays(int n, int k) {
		if (n < 1) return 0;
        int sameColor = 0, diffColor = k;
        for (int i = 1; i < n; i++) {
        	int temp = diffColor;
        	diffColor = (sameColor + diffColor) * (k - 1);
        	sameColor = temp;
        }
        return sameColor + diffColor;
    }
}
