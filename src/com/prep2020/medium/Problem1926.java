package com.prep2020.medium;
import java.util.*;
public class Problem1926 {
	public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        q.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        					|| maze[next[0]][next[1]] == '+') continue; 
        			if (next[0] == m - 1 || next[0] == 0 || next[1] == n - 1 
        					|| next[1] == 0) return result;
        			maze[next[0]][next[1]] = '+';
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }
}
