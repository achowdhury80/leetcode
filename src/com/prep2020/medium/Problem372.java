package com.prep2020.medium;

public class Problem372 {
	/**
	 * O(N)
	 * @param a
	 * @param b
	 * @return
	 */
	public int superPow(int a, int[] b) {
        if (a < 2) return a;
        int result = 1, mod = 1337;
        for (int i = b.length - 1; i > -1; i--) {
        	result = (int)((1l * result * powerMod(a, b[i])) % mod);
        	a = powerMod(a, 10);
        }
        return result;
    }

	private int powerMod(int a, int b) {
		if (b == 0) return 1;
		int result = 1;
		for (int i = 0; i < b; i++) result = (int)((1l * result * a) % 1337);
		return result;
	}
}
