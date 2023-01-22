package com.prep2020.medium;

public class Problem1905 {
	/**
	 * O(N)
	 * @param grid1
	 * @param grid2
	 * @return
	 */
	public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid2[i][j] == 1) {
        			result += helper(grid1, grid2, new int[] {i, j});
        		}
        	}
        }
        return result;
    }

	private int helper(int[][] grid1, int[][] grid2, int[] cur) {
		int result = 1;
		if (grid1[cur[0]][cur[1]] != 1) result = 0;
		grid2[cur[0]][cur[1]] = -1;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		for (int[] dir : dirs) {
			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
			if (next[0] < 0 || next[0] == grid1.length || next[1] < 0 || next[1] == grid1[0].length 
					|| grid2[next[0]][next[1]] != 1) continue;
			result *= helper(grid1, grid2, next);
		}
		return result;
	}
}
