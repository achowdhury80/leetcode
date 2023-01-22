package com.prep2020.medium;
import java.util.*;
public class Problem994 {
	/**
	 * O(M*N)
	 * @param grid
	 * @return
	 */
	public int orangesRotting(int[][] grid) {
		int m = grid.length, n = grid[0].length;
        int rotten = 0, total = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] != 0) total++;
        		if (grid[i][j] == 2) {
        			rotten++;
        			q.offer(new int[] {i, j});
        		}
        	}
        }
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(total != rotten && !q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] < 0 || next[0] == m || next[1] < 0 
        					|| next[1] == n || grid[next[0]][next[1]] != 1) 
        				continue;
        			grid[next[0]][next[1]] = 2;
        			rotten++;
        			q.offer(next);
        		}
        	}
        }
        return total == rotten ? result : -1;
    }
}
