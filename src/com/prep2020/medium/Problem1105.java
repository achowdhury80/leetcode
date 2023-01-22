package com.prep2020.medium;

public class Problem1105 {
	/**
	 * O(N^2)
	 * @param books
	 * @param shelf_width
	 * @return
	 */
	public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        int[] dp = new int[n];
        dp[n - 1] = books[n - 1][1];
        for (int i = n - 2; i > -1; i--) {
        	int width = books[i][0], maxHeight = books[i][1], totalHeight = books[i][1] + dp[i + 1];
        	int j = i + 1;
        	while(j < n && width + books[j][0] <= shelf_width) {
        		width += books[j][0];
        		maxHeight = Math.max(maxHeight, books[j][1]);
        		totalHeight = Math.min(totalHeight, maxHeight + (j == n - 1 ? 0 : dp[j + 1]));
        		j++;
        	}
        	dp[i] = totalHeight;
        }
        return dp[0];
    }
	
	public static void main(String[] args) {
		Problem1105 problem = new Problem1105();
		System.out.println(problem.minHeightShelves(new int[][] {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}}, 4));
	}
}
