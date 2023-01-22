package com.prep2020.hard;

import java.util.Arrays;

public class Problem1478 {
	public int minDistance(int[] houses, int k) {
		Arrays.sort(houses);
        int n = houses.length;
        int[][][] dp = new int[n][n][k + 1];
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < n; j++) {
        		for (int x = 0; x <= k; x++) {
        			dp[i][j][x] = Integer.MAX_VALUE;
        		}
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = i; j < n; j++) {
        		dp[i][j][1] = findMinDistance(houses, i, j);
        	}
        }
        for (int i = 2; i <= k; i++) {
        	for (int j = 0; j + i <= n; j++) {
        		for (int x = j + i - 1; x < n; x++) {
        			for (int y = j; x - y >= i - 1; y++) {
        				dp[j][x][i] = Math.min(dp[j][x][i], dp[j][y][1] + dp[y + 1][x][i - 1]);
        			}
        		}
        	}
        }
        return dp[0][n - 1][k];
    }

	private int findMinDistance(int[] houses, int i, int j) {
		if (i == j) return 0;
		int pos = -1;
		if ((j - i) % 2 == 0) {
			pos = houses[i + (j - i) / 2];
		} else {
			pos = (houses[i + (j - i) / 2] + houses[i + (j - i) / 2]) / 2;
		}
		int result = 0;
		for (int x = i; x <= j; x++) {
			result += Math.abs(pos - houses[x]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1478 problem = new Problem1478();
		System.out.println(problem.minDistance(new int[] {1,4,8,10,20}, 3));
	}
}
