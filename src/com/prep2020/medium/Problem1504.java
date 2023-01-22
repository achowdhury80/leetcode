package com.prep2020.medium;

public class Problem1504 {
	public int numSubmat(int[][] mat) {
		int dp[][] = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			int c = 0;
			for (int j = mat[0].length - 1; j >= 0; j--) {
				if (mat[i][j] == 1) {
					c++;
				} else c = 0;
				dp[i][j] = c;
			}
		}
		int ans = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int x = Integer.MAX_VALUE;
				for (int k = i; k < mat.length; k++) {
					x = Math.min(x, dp[k][j]);
					ans += x;
				}
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Problem1504 problem = new Problem1504();
		System.out.println(problem.numSubmat(new int[][] {{0,1,1,0},{0,1,1,1},{1,1,1,0}}));
	}
}
