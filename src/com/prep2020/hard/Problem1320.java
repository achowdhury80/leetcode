package com.prep2020.hard;

public class Problem1320 {
	public int minimumDistance(String word) {
        int[][] dp = new int[][] {{0, -1, -1}, {0, -1, -1}};
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	int[] arr1 = new int[] {0, -1, -1}, arr2 = new int[] {0, -1, -1};
        	// first finger move
        	// case 1, 1st finger
        	int min1 = dp[0][0];
        	if (dp[0][1] != -1)  {
        		min1 += distance((char)dp[0][1], arr[i]);
        	} 
        	int min2 = dp[1][0];
        	if (dp[1][1] != -1) min2 += distance((char)dp[1][1], arr[i]);
        	if (min1 <= min2) {
        		arr1 = new int[] {min1, (int)arr[i], dp[0][2]};
        	} else arr1 = new int[] {min2, (int)arr[i], dp[1][2]};
        	
        	min1 = dp[0][0];
        	if (dp[0][2] != -1)  {
        		min1 += distance((char)dp[0][2], arr[i]);
        	} 
        	min2 = dp[1][0];
        	if (dp[1][2] != -1) min2 += distance((char)dp[1][2], arr[i]);
        	if (min1 <= min2) {
        		arr2 = new int[] {min1, dp[0][1], (int)arr[i]};
        	} else arr2 = new int[] {min2, dp[1][1], (int)arr[i]};
        	dp[0] = arr1;
        	dp[1] = arr2;
        }
        return Math.min(dp[0][0], dp[1][0]);
    }
	
	private int[] findCoOrdinate(char c) {
		int i = c - 'A';
		return new int[] {i / 6, i % 6};
	}
	
	private int distance(char c1, char c2) {
		int[] x = findCoOrdinate(c1), y = findCoOrdinate(c2);
		return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
	}
	
	public static void main(String[] args) {
		Problem1320 problem = new Problem1320();
		System.out.println(problem.minimumDistance("cake"));
	}
}
