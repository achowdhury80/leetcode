package com.prep2020.medium;
import java.util.*;
public class Problem1631 {
	public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        pq.offer(new int[] {0, 0, 0});
        int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		effort[i][j] = Integer.MAX_VALUE;
        	}
        }
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[0] >= effort[cur[1]][cur[2]]) continue;
        	effort[cur[1]][cur[2]] = cur[0];
        	if (cur[1] == m - 1 && cur[2] == n - 1) return cur[0];
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[1] + dir[0], cur[2] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n) continue;
        		pq.offer(new int[] {Math.max(cur[0], Math.abs(heights[cur[1]][cur[2]] - heights[next[0]][next[1]])), next[0], next[1]});
        	}
        }
        return effort[m - 1][n - 1];
    
    }
	
	public static void main(String[] args) {
		Problem1631 problem = new Problem1631();
		System.out.println(problem.minimumEffortPath(new int[][] {{1, 2, 2}, 
			{3, 8, 2}, {5, 3, 5}}));
	}
}
