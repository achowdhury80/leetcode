package com.prep2020.medium;
import java.util.*;
public class Problem695 {
	/**
	 * O(m * n)
	 * @param grid
	 * @return
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int result = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			result = Math.max(result, findArea(grid, new int[] {i, j}));
        		}
        	}
        }
        return result;
    }

	private int findArea(int[][] grid, int[] pos) {
		int result = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(pos);
		grid[pos[0]][pos[1]] = -1;
		int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == grid.length || next[1] < 0 || next[1] == grid[0].length 
						|| grid[next[0]][next[1]] != 1) continue;
				result++;
				q.offer(next);
				grid[next[0]][next[1]] = -1;
			}
		}
		return result;
	}
}
