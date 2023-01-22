package com.prep2020.medium;

public class Problem371 {
	/**
	 * O(1)
	 * @param a
	 * @param b
	 * @return
	 */
	public int getSum(int a, int b) {
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }
}
