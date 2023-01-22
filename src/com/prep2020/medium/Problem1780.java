package com.prep2020.medium;

public class Problem1780 {
	/**
	 * O(logN)
	 * @param n
	 * @return
	 */
	public boolean checkPowersOfThree(int n) {
        return helper(n, n + 1);
    }
	
	private boolean helper(int n, int max) {
        if (n == 2) return false;
        if (n < 2) return true;
        int prod = 3;
        while(prod * 3 <= n && prod * 3 < max) prod *= 3;
        if (prod >= max) return false;
        return helper(n - prod, prod);
    }
}
