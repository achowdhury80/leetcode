package com.prep2020.medium;
import java.util.*;
public class Problem200 {
	/**
	 * O(N)
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		int m = grid.length, n = grid[0].length;
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '1') {
        			result++;
        			q.offer(new int[] {i, j});
        			grid[i][j] = '2';
        			while(!q.isEmpty()) {
        				int[] cur = q.poll();
        				for (int[] dir : dirs) {
        					int[] next 
        						= new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        					if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n
        							&& grid[next[0]][next[1]] == '1') {
        						q.offer(next);
        						grid[next[0]][next[1]] = '2';
        					}
        				}
        			}
        		}
        	}
        }
        for (int i = 0; i < m; i++)
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '2')
        		grid[i][j] = '1';
        	}
        return result;
    }
}
