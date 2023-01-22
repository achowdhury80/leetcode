package com.prep2020.easy;

public class Problem1304 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int[] sumZero(int n) {
        int[] result = new int[n];
        int idx = 0;
        if (n % 2 == 1) {
        	n--;
        	result[idx++] = 0;
        }
        for (int i = 1; i <= n / 2; i++) {
        	result[idx++] = i;
        	result[idx++] = -i;
        }
        return result;
    }
}
