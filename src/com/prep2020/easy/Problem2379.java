package com.prep2020.easy;

public class Problem2379 {
	public int minimumRecolors(String blocks, int k) {
        int result = Integer.MIN_VALUE;
        int n = blocks.length(), count = 0;
        for (int i = 0; i < n; i++) {
        	count += blocks.charAt(i) == 'B' ? 1 : 0;
        	if (i >= k) count -= blocks.charAt(i - k) == 'B' ? 1 : 0;
        	result = Math.max(result, count);
        }
        return k - result;
    }
}
