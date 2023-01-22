package com.prep2020.easy;

public class Problem2432 {
	
	public int hardestWorker(int n, int[][] logs) {
		int result = Integer.MAX_VALUE, time = Integer.MIN_VALUE;
		int last = 0;
		for (int[] x : logs) {
			int spent = x[1] - last;
			last = x[1];
			if (spent > time) {
				time = spent;
				result = x[0];
			} else if (spent == time && x[0] < result) {
				result = x[0];
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem2432 problem = new Problem2432();
		System.out.println(problem.hardestWorker(10, new int[][]{{0,3},{2,5},{0,9},{1,15}}));
	}
	
}
