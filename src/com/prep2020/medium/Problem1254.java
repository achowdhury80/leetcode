package com.prep2020.medium;
import java.util.*;
public class Problem1254 {
	/**
	 * O(N) time and space
	 * @param grid
	 * @return
	 */
	public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 0 && isIsland(grid, new int[] {i, j})) result++;
        	}
        }
        return result;
    }

	private boolean isIsland(int[][] grid, int[] pos) {
		boolean result = true;
		int m = grid.length, n = grid[0].length;
		Queue<int[]> q = new LinkedList<>();
		grid[pos[0]][pos[1]] = -1;
		q.offer(pos);
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir: dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) {
					result = false;
					continue;
				}
				if (grid[next[0]][next[1]] == 0) {
					grid[next[0]][next[1]] = -1;
					q.offer(next);
				}
			}
		}
		return result;
	}
}
