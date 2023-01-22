package com.prep2020.easy;
import java.util.*;
public class Problem1337 {
	/**
	 * o(nlogK)
	 * @param mat
	 * @param k
	 * @return
	 */
	public int[] kWeakestRows(int[][] mat, int k) {
        Queue<int[]> maxQ = new PriorityQueue<>((x, y) 
        		-> (x[1] == y[1] ? (y[0] - x[0]) : (y[1] - x[1])));
        for (int i = 0; i < mat.length; i++) {
        	int count = 0;
        	for (int j = 0; j < mat[0].length; j++) {
        		if (mat[i][j] == 1) count++;
        	}
        	maxQ.offer(new int[] {i, count});
        	if (maxQ.size() > k) maxQ.poll();
        }
        int[] result = new int[k];
        for (int i = k - 1; i > -1; i--) {
        	result[i] = maxQ.poll()[0];
        }
        return result;
    }
}
