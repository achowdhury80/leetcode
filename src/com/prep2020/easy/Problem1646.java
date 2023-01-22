package com.prep2020.easy;

public class Problem1646 {
	public int getMaximumGenerated(int n) {
		if (n < 2) return n;
		int[] arr = new int[n + 1];
		arr[1] = 1;
		int result = 1;
		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) arr[i] = arr[i / 2];
			else arr[i] = arr[i / 2] + arr[i / 2 + 1];
			result = Math.max(result, arr[i]);
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem1646 problem = new Problem1646();
		System.out.println(problem.getMaximumGenerated(15));
	}
}
