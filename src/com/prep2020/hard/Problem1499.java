package com.prep2020.hard;
import java.util.*;
public class Problem1499 {
	public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = points[i][1] - points[i][0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
        	while(!dq.isEmpty() && points[i][0] - points[dq.peekFirst()][0] > k) dq.pollFirst();
        	if (!dq.isEmpty()) result = Math.max(result, points[i][1] + points[i][0] + arr[dq.peekFirst()]);
        	while(!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
        	dq.offerLast(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1499 problem = new Problem1499();
		System.out.println(problem.findMaxValueOfEquation(new int[][] {{1, 3}, {2, 0}, {5, 10}, {6, -10}}, 1));
	}
}
