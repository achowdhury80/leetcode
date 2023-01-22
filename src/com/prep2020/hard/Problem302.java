package com.prep2020.hard;
import java.util.*;
public class Problem302 {
	public int minArea(char[][] image, int x, int y) {
        int[] minMaxX = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE}, minMaxY = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	minMaxX[0] = Math.min(minMaxX[0], cur[0]);
            minMaxX[1] = Math.max(minMaxX[1], cur[0]);
            minMaxY[0] = Math.min(minMaxY[0], cur[1]);
            minMaxY[1] = Math.max(minMaxY[1], cur[1]);
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n || image[next[0]][next[1]] == '0' || visited[next[0]][next[1]]) continue;
        		visited[next[0]][next[1]] = true;
        		q.offer(next);
        	}
        }
        
        return (minMaxX[1] - minMaxX[0] + 1) * (minMaxY[1] - minMaxY[0] + 1);
    }
}
