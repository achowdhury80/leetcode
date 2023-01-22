package com.prep2020.medium;
import java.util.*;
public class Problem286 {
	/**
	 * O(M*N)
	 * @param rooms
	 */
	public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (rooms[i][j] == 0) {
        			q.offer(new int[] {i, j});
        		}
        	}
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] > -1 && next[0] < m && next[1] > -1 && next[1] < n 
        					&& rooms[next[0]][next[1]] == Integer.MAX_VALUE) {
        				rooms[next[0]][next[1]] = rooms[cur[0]][cur[1]] + 1;
        				q.offer(next);
        			}
        		}
        	}
        }
    }
}
