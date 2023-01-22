package com.prep2020.medium;
import java.util.*;
public class Problem1730 {
	public int getFood(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] start = null;
        boolean found = false;
        for (int i = 0; i < m ; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == '*') {
        			start = new int[] {i, j};
        			found = true;
        			break;
        		}
        	}
        	if (found) break;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] < 0 || next[1] < 0 || next[1] == n 
        					|| next[0] == m) continue;
        			if (grid[next[0]][next[1]] == '#') return result;
        			if (grid[next[0]][next[1]] == 'O') {
        				grid[next[0]][next[1]] = 'V';
        				q.offer(next);
        			}
        		}
        	}
        }
        return -1;
    }
}
