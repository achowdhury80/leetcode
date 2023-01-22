package com.prep2020.medium;
import java.util.*;
public class Problem378 {
	/**
	 * O(N^2)
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> 
        	matrix[x[0]][x[1]] - matrix[y[0]][y[1]]);
        pq.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while(!pq.isEmpty() && k > 1) {
        	int[] pos = pq.poll();
        	if (pos[0] + 1 < n && !visited[pos[0] + 1][pos[1]]) {
        		pq.offer(new int[] {pos[0] + 1, pos[1]});
        		visited[pos[0] + 1][pos[1]] = true;
        	}
        	if (pos[1] + 1 < n && !visited[pos[0]][pos[1] + 1]) {
        		pq.offer(new int[] {pos[0], pos[1] + 1});
        		visited[pos[0]][pos[1] + 1] = true;
        	}
        	k--;
        }
        int[] pos = pq.poll();
        return matrix[pos[0]][pos[1]];
    }
}
