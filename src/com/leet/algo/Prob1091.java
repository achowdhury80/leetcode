package com.leet.algo;
import java.util.*;
public class Prob1091 {
	/**
	 * BFS
	 * @param grid
	 * @return
	 */
	public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 1});
        int[][] directions = new int[][] {{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
        while (!q.isEmpty()) {
        	int[] pos = q.poll();
        	if (pos[0] == n - 1 && pos[1] == n - 1) return pos[2];
        	for (int[] dir : directions) {
        		int[] newPos = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
        		if (newPos[0] > -1 && newPos[1] > -1 && newPos[0] < n && newPos[1] < n && grid[newPos[0]][newPos[1]] == 0) {
        			grid[newPos[0]][newPos[1]] = 2;
        			q.offer(new int[] {newPos[0], newPos[1], pos[2] + 1});
        		}
        	}
        }
        return -1;
    }
}
