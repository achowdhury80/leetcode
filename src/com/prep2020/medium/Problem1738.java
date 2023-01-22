package com.prep2020.medium;
import java.util.*;
public class Problem1738 {
	/**
	 * O(m * n (1 + logk))
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        Queue<Integer> minQ = new PriorityQueue<>((x, y) -> x - y);
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		matrix[i][j] ^= (i > 0 ? matrix[i - 1][j] : 0) ^ (j > 0 ? matrix[i][j - 1] : 0) 
        				^ (i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0); 
        		minQ.offer(matrix[i][j]);
        		if (minQ.size() > k) minQ.poll();
        	}
        }
        return minQ.poll();
    }	
}
