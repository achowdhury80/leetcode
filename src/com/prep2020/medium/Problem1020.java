package com.prep2020.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1020 {
	/**
	 * O(m * n)
	 * @param grid
	 * @return
	 */
	public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < n; i++) {
        	if (grid[0][i] == 1) {
        		bfs(grid, new int[] {0, i});
        	}
        	if (grid[m - 1][i] == 1) {
        		bfs(grid, new int[] {m - 1, i});
        	}
        }
        for (int i = 0; i < m; i++) {
        	if (grid[i][0] == 1) {
        		bfs(grid, new int[] {i, 0});
        	}
        	if(grid[i][n - 1] == 1) {
        		bfs(grid, new int[] {i, n - 1});
        	}
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) result++;
        	}
        }
        return result;
    }
	
	public void bfs(int[][] A, int[] cur) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(cur);
		A[cur[0]][cur[1]] = 0;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		while(!q.isEmpty()) {
			cur = q.poll();
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] > -1 && next[0] < A.length && next[1] > -1 
						&& next[1] < A[0].length && A[next[0]][next[1]] == 1) {
					q.offer(next);
					A[next[0]][next[1]] = 0;
				}
			}
		}
	}
}
