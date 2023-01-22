package com.prep2020.easy;

public class Problem342 {
	/**
	 * O(1)
	 * @param n
	 * @return
	 */
	public boolean isPowerOfFour(int n) {
        for (int i = 0; i < 32; i += 2) {
        	if ((n ^ (1 << i)) == 0) return true;
        }
        return false;
    }
}
