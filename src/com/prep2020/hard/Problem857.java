package com.prep2020.hard;

import java.util.*;

public class Problem857 {
	/**
	 * O(NlogN) time and O(N) space
	 * @param quality
	 * @param wage
	 * @param k
	 * @return
	 */
	public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> 
        	Double.compare((wage[x] + 0.0) / quality[x], 
        			(wage[y] + 0.0) / quality[y]));
        int sumQ = 0;
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        double result = Double.MAX_VALUE;
        for (int i : arr) {
        	sumQ += quality[i];
        	if (q.size() == k) sumQ -= q.poll();
        	q.offer(quality[i]);
        	if (q.size() == k) {
        		result = Math.min(result, ((wage[i] + 0.0) / quality[i]) * sumQ);
        	}
        }
        return result;
    }
}
