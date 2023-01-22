package com.prep2020.medium;
import java.util.*;
public class Problem973 {
	/**
	 * O(NlogK)
	 * @param points
	 * @param K
	 * @return
	 */
	 public int[][] kClosest(int[][] points, int K) {
	        Queue<int[]> q = new PriorityQueue<>(
	        		(x, y) -> (y[0] * y[0] + y[1] * y [1]) 
	        		- (x[0] * x[0] + x[1] * x[1]));
	        for (int[] pt : points) {
	        	q.offer(pt);
	        	if (q.size() > K) q.poll();
	        }
	        int[][] result = new int[q.size()][2];
	        for (int i = result.length - 1; i > -1; i--) result[i] = q.poll();
	        return result;
	 }
}
