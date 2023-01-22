package com.prep2020.medium;
import java.util.*;
public class Problem1034 {
	/*
	 * O(m * n)
	 */
	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
		if (grid[row][col] == color) return grid;
		int sourceColor = grid[row][col];
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(new int[] {row, col});
        visited[row][col] = true;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	boolean isInBorder = false;
        	if (cur[0] == 0 || cur[0] == m - 1 || cur[1] == 0 || cur[1] == n - 1) 
        		isInBorder = true;
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
        		if (visited[next[0]][next[1]]) continue;
        		if (grid[next[0]][next[1]] != sourceColor) isInBorder = true;
        		else {
        			visited[next[0]][next[1]] = true;
        			q.offer(next);
        		}
        	}
        	if(isInBorder) grid[cur[0]][cur[1]] = color;
        }
        return grid;
    }
}
