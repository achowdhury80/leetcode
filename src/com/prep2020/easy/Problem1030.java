package com.prep2020.easy;
import java.util.*;
public class Problem1030 {
	public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        boolean[][] visited = new boolean[R][C];
        int[][] result = new int[R * C][2];
        int i = 0;
        result[i++] = new int[] {r0, c0};
        visited[r0][c0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {r0, c0});
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int[] cell = q.poll();
        	for (int[] dir : dirs) {
        		int[] next = new int[] {cell[0] + dir[0], cell[1] + dir[1]};
        		if (next[0] < 0 || next[0] == R || next[1] < 0 || next[1] == C 
        				|| visited[next[0]][next[1]]) continue;
        		result[i++] = next;
        		visited[next[0]][next[1]] = true;
        		q.offer(next);
        	}
        }
        return result;
    }
}
