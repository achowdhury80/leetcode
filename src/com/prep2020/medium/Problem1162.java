package com.prep2020.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1162 {
	public int maxDistance(int[][] grid) {
		int n = grid.length;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) q.offer(new int[] {i, j});
			}
		}
		if (q.isEmpty() || q.size() == n * n) return -1;
		int result = -1;
		int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!q.isEmpty()) {
			result++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
					if (next[0] > - 1 && next[0] < n && next[1] > - 1 
							&& next[1] < n && grid[next[0]][next[1]] == 0) {
						q.offer(next);
						grid[next[0]][next[1]] = -1;
					}
				}
			}
		}
		return result;
	}
}
