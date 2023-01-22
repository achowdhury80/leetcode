package com.prep2020.medium;

public class Problem667 {
	/**
	 * O(N)
	 * @param n
	 * @param k
	 * @return
	 */
	public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int min = 1, max = n, idx = 0;
        result[idx++] = min++;
        while(k > 2) {
        	result[idx++] = max--;
        	result[idx++] = min++;
        	k -= 2;
        }
        if (k == 1) {
        	for (int i = idx; i < n; i++) {
        		result[i] = min++;
        	}
        } else if (k == 2) {
        	result[idx++] = max--;
        	for (int i = idx; i < n; i++) {
        		result[i] = max--;
        	}
        }
        return result;
    }
}
