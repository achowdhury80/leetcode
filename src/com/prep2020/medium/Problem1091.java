package com.prep2020.medium;
import java.util.*;
public class Problem1091 {
	/**
	 * O(n^2)
	 * @param grid
	 * @return
	 */
	public int shortestPathBinaryMatrix(int[][] grid) {
        int  n = grid[0].length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;
        if (n == 1) return 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        grid[0][0] = -1;
        int result = 1;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1},
        	{1, -1}, {1, 1}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] == n - 1 && next[1] == n - 1) return result;
        			if (next[0] < 0 || next[0] == n || next[1] < 0 || next[1] == n
        					|| grid[next[0]][next[1]] != 0) continue;
        			grid[next[0]][next[1]] = -1;
        			q.offer(next);
        		}
        	}
        }
        return -1;	
    }
}
