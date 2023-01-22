package com.prep2020.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1391 {
	public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return true;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        int[][][] dirs = new int[][][] {
        	{{0, 1}, {0, -1}},
        	{{-1, 0}, {1, 0}},
        	{{0, -1}, {1, 0}},
        	{{0, 1}, {1, 0}},
        	{{0, -1}, {-1, 0}},
        	{{0, 1}, {-1, 0}},
        };
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	for (int[] dir : dirs[grid[cur[0]][cur[1]] - 1]) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n
        				|| visited[next[0]][next[1]] || !isValid(grid, cur, next)) 
        			continue;
        		if (next[0] == m - 1 && next[1] == n - 1) return true;
        		
        		q.offer(next);
        		visited[next[0]][next[1]] = true;
        	}
        }
        return false;
    }
	
	private boolean isValid(int[][] grid, int[] cur, int[] next) {
		int nextVal = grid[next[0]][next[1]];
		if (cur[0] == next[0]) {
			// next is on the left
			if (cur[1] == next[1] + 1) {
				if (nextVal == 1 || nextVal == 4 || nextVal == 6) return true;
			} else {
				if (nextVal == 1 || nextVal == 3 || nextVal == 5) return true;
			}
		} else {
			// next is the upper cell
			if (cur[0] == next[0] + 1) {
				if (nextVal == 2 || nextVal == 3 || nextVal == 4) return true;
			} else {
				if (nextVal == 2 || nextVal == 5 || nextVal == 6) return true;
			}
		}
		return false;
	}
}
