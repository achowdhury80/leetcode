package com.prep2020.medium;

public class Problem1219 {
	/**
	 * O(4^n) time and O(N) space
	 * @param grid
	 * @return
	 */
	public int getMaximumGold(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] != 0) {
        			result = Math.max(result, dfs(grid, new int[] {i, j}));
        		}
        	}
        }
        return result;
    }

	private int dfs(int[][] grid, int[] cur) {
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		int val = grid[cur[0]][cur[1]];
		int result = val;
		grid[cur[0]][cur[1]] *= -1;
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] > -1 && next[0] < grid.length && next[1] > -1 
					&& next[1] < grid[0].length 
					&& grid[next[0]][next[1]] > 0) {
				result = Math.max(result, val + dfs(grid, next));
			}
		}
		grid[cur[0]][cur[1]] *= -1;
		return result;
	}
}
