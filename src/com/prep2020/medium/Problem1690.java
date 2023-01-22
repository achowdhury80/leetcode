package com.prep2020.medium;

public class Problem1690 {
	/**
	 * O(N^2) time and space
	 * @param stones
	 * @return
	 */
	public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < stones.length; i++) sum[i + 1] = sum[i] + stones[i];
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		cache[i][j] = Integer.MAX_VALUE;
        	}
        }
        return findDiff(stones, 0, n - 1, sum, cache);
    }
	
	private int findDiff(int[] stones, int start, int end, int[] sum, int[][] cache) {
		if (cache[start][end] != Integer.MAX_VALUE) return cache[start][end];
		if (start == end) {
			cache[start][end] = 0;
			return 0;
		}
		if (start + 1 == end) {
			cache[start][end] = Math.max(stones[start], stones[end]);
			return cache[start][end];
		}
		int leftSelectedSum = sum[end + 1] - sum[start + 1];
		int leftSelectedDiff = leftSelectedSum - findDiff(stones, start + 1, end, sum, cache);
		int rightSelectedSum = sum[end] - sum[start];
		int rightSelectedDiff = rightSelectedSum - findDiff(stones, start, end - 1, sum, cache);
		cache[start][end] = Math.max(leftSelectedDiff, rightSelectedDiff);
		return cache[start][end];
	}
}
