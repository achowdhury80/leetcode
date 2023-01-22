package com.prep2020.medium;
import java.util.*;
public class Problem1727 {
	/**
	 * O(mnlogn)
	 * @param matrix
	 * @return
	 */
	public int largestSubmatrix(int[][] matrix) {
        int maxArea = 0, m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
        	Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 1) {
        			if (i > 0) matrix[i][j] += matrix[i - 1][j];
        			pq.offer(matrix[i][j]);
        		}
        	}
        	
        	int width = 0;
        	while(!pq.isEmpty()) {
        		width++;
        		int height = pq.poll();
        		maxArea = Math.max(maxArea, height * width);
        	}
        }
        return maxArea;
    }
}
