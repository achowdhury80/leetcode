package com.prep2020.medium;

public class Problem1318 {
	/**
	 * O(1)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int minFlips(int a, int b, int c) {
		int result = 0;
        while(a > 0 || b > 0 || c > 0) {
        	int a0 = a & 1, b0 = b & 1, c0 = c & 1;
        	if (c0 == 0) result += a0 + b0;
        	else result += (a0 + b0) > 0 ? 0 : 1;
        	a >>= 1;
        	b >>= 1;
        	c >>= 1;
        }
        return result;
    }
}
