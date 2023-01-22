package com.prep2020.easy;

public class Problem231 {
	/**
	 * O(1)
	 * @param n
	 * @return
	 */
	public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (n > 0) n &= (n - 1);
        return n == 0;
    }
}
