package com.prep2020.medium;

public class Problem634 {
	/**
	 * D(n) = (n - 1)(D(n - 2) + D(n - 1))
	 * D(2) = 1
	 * @param n
	 * @return
	 */
	public int findDerangement(int n) {
        int mod = (int)(1e9 + 7);
        if (n < 2) return 0;
        if (n == 2) return 1;
        long d1 = 0, d2 = 1, val = 0;
        for (int i = 3; i <= n; i++) {
        	val = ((i - 1) * ((d1 + d2) % mod)) % mod;
        	d1 = d2;
        	d2 = val;
        }
        return (int)val;
    }
}
