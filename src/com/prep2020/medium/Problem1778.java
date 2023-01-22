package com.prep2020.medium;
import java.util.*;
public class Problem1778 {
	public int findShortestPath(GridMaster master) {
        int[][] grid = new int[1002][1002];
        int[] start = new int[] {501, 501};
        boolean[] seen = new boolean[1];
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        grid[start[0]][start[1]] = -1;
        dfs(master, grid, start, seen, dirs);
        if (!seen[0]) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int j = 0; j < dirs.length; j++) {
        			int[] next = new int[] {cur[0] + dirs[j][0], cur[1] + dirs[j][1]};
        			if (grid[next[0]][next[1]] == 2) return result;
        			if (grid[next[0]][next[1]] != 1) continue;
        			grid[next[0]][next[1]] = -1;
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }
	
	private void dfs(GridMaster master, int[][] grid, int[] cur, boolean[] seen, int[][] dirs) {
		if (master.isTarget()) {
			grid[cur[0]][cur[1]] = 2;
			seen[0] = true;
		}
		for (int i = 0; i < dirs.length; i++) {
			if (!master.canMove("DURL".charAt(i))) continue;
			int[] next = new int[] {cur[0] + dirs[i][0], cur[1] + dirs[i][1]};
			if (grid[next[0]][next[1]] != 0) continue;
			grid[next[0]][next[1]] = 1;
			master.move("DURL".charAt(i));
			dfs(master, grid, next, seen, dirs);
			int backIndex = i ^ 1;
			master.move("DURL".charAt(backIndex));
		}
	}
	
	interface GridMaster {
	     boolean canMove(char direction);
	     void move(char direction);
	     boolean isTarget();
	}
}
