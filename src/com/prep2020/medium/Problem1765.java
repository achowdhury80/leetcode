package com.prep2020.medium;
import java.util.*;
public class Problem1765 {
	public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> q = new LinkedList<>();
        int m = isWater.length, n = isWater[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (isWater[i][j] == 1) {
        			q.offer(new int[] {i, j});
	        		visited[i][j] = true;
	        		isWater[i][j] = 0;
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
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n || visited[next[0]][next[1]])
        				continue;
        			isWater[next[0]][next[1]] = isWater[cur[0]][cur[1]] + 1;
        			visited[next[0]][next[1]] = true;
        			q.offer(next);
        		}
        	}
        }
        return isWater;
    }
	
	public static void main(String[] args) {
		Problem1765 problem = new Problem1765();
		System.out.println(problem.highestPeak(new int[][] {{0, 1}, {0, 0}}));
	}
}
