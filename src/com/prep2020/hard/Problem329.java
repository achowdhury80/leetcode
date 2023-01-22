package com.prep2020.hard;
import java.util.*;
public class Problem329 {
	/**
	 * O(mn)
	 * @param matrix
	 * @return
	 */
	public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indeg = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (i > 0 && matrix[i - 1][j] < matrix[i][j]) indeg[i][j]++;
        		if (i < m - 1 && matrix[i + 1][j] < matrix[i][j]) indeg[i][j]++;
        		if (j > 0 && matrix[i][j - 1] < matrix[i][j]) indeg[i][j]++;
        		if (j < n - 1 && matrix[i][j + 1] < matrix[i][j]) indeg[i][j]++;
        	}
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (indeg[i][j] == 0) q.offer(new int[] {i, j});
        	}
        }
        int result = 0;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1]};
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        					|| matrix[next[0]][next[1]] <= matrix[cur[0]][cur[1]]) continue;
        			indeg[next[0]][next[1]]--;
        			if (indeg[next[0]][next[1]] == 0) q.offer(next);
        		}
        	}
        }
        return result;
    }
}
