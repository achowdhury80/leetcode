package com.prep2020.hard;
import java.util.*;
public class Problem827 {
	public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[] result = new int[] {1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			helper(grid, new int[] {i, j}, result, map);
        		}
        	}
        }
        for (int val : map.values()) result[0] = Math.max(result[0], val + 1);
        return result[0];
    }

	private void helper(int[][] grid, int[] pos, int[] result, Map<Integer, Integer> map) {
		int n = grid.length;
		int count = 0;
		int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		Queue<int[]> q = new LinkedList<>();
		q.offer(pos);
		grid[pos[0]][pos[1]] = -1;
		Set<Integer> neighbors = new HashSet<>();
 		while(!q.isEmpty()) {
			int[] cur = q.poll();
			count++;
			for (int[] dir : dirs) {
				int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
				if (next[0] < 0 || next[0] == n || next[1] < 0 || next[1] == n || grid[next[0]][next[1]] == -1) continue;
				if (grid[next[0]][next[1]] == 1) {
					q.offer(next);
					grid[next[0]][next[1]] = -1;
				} else {
					int mask = (next[0] << 9) | next[1];
					neighbors.add(mask);
				}
			}
		}
		for (int mask : neighbors) {
			map.put(mask, map.getOrDefault(mask, 0) + count);
		}
		result[0] = Math.max(result[0], count);
	}
}
