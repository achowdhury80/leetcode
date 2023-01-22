package com.prep2020.easy;

public class Problem1952 {
	/**
	 * O(sqrt(n))
	 * @param n
	 * @return
	 */
	public boolean isThree(int n) {
        if (n < 3) return false;
        for (int i = 2; i * i <= n; i++) {
        	if (i * i == n) return true;
        	if (n % i == 0) return false;
        }
        return false;
    }
}
