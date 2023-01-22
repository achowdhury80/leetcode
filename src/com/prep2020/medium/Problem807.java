package com.prep2020.medium;

public class Problem807 {
	/**
	 * O(M *N)
	 * 
	 * @param grid
	 * @return
	 */
	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowMax = new int[m], colMax = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		rowMax[i] = Math.max(rowMax[i], grid[i][j]);
        		colMax[j] = Math.max(colMax[j], grid[i][j]);
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		// min of row max and col max
        		int max = Math.min(rowMax[i],  colMax[j]);
        		result += (max - grid[i][j]);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem807 problem = new Problem807();
		System.out.println(problem.maxIncreaseKeepingSkyline(new int[][] {
			{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
	}
}
