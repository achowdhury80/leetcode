package com.leet.algo;

public class Prob1105 {
	/**
	 * dp[i] means total height by placing i-1th book in the next rack
	 * so, if n previous books can be placed in the rack, find best dp[i] for all the case
	 * @param books
	 * @param shelf_width
	 * @return
	 */
	public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        dp[0] = 0;
        for (int i = 1; i < books.length + 1; i++) {
        	int height = books[i - 1][1];
        	int width = books[i - 1][0];
        	dp[i] = dp[i - 1] + height;
        	for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelf_width; j--) {
        		height = Math.max(height, books[j - 1][1]);
        		width = width + books[j - 1][0];
        		dp[i] = Math.min(dp[i], dp[j - 1] + height);
        	}
        }
        return dp[books.length];
    }
}
