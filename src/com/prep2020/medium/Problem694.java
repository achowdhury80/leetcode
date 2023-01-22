package com.prep2020.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem694 {
	/**
	 * O(M*N) time and space
	 * https://leetcode.com/problems/number-of-distinct-islands/solution/
	 * @param grid
	 * @param seen
	 * @param r
	 * @param c
	 * @param r0
	 * @param c0
	 * @param shape
	 */
	public int numDistinctIslands(int[][] grid) {
		int n;
		if (grid.length < 1 || (n = grid[0].length) < 1) return 0;
		Set<Set<Integer>> shapes = new HashSet<>();
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					Set<Integer> shape = new HashSet<>();
					int[] basePos = new int[] {i, j};
					Queue<int[]> q = new LinkedList<>();
					q.offer(new int[] {i, j});
					grid[i][j] = -1;
					shape.add(0);
					while(!q.isEmpty()) {
						int[] cur = q.poll();
						for (int[] dir : dirs) {
							int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
							if (next[0] < 0 || next[0] == grid.length || next[1] < 0 
									|| next[1] == n || grid[next[0]][next[1]] != 1) 
								continue;
							grid[next[0]][next[1]] = -1;
							shape.add((next[0] - basePos[0]) * 2 * n 
									+ (next[1] - basePos[1]));
							q.offer(next);
						}
					}
					shapes.add(shape);
				}
				
			}
		}
		return shapes.size();
    }
}
