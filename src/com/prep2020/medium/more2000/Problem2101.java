package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2101 {
	public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[] detonated = new boolean[n];
        Arrays.sort(bombs, (x, y) -> (y[2] - x[2]));
        int result = 0;
        for (int i = 0; i < n; i++) {
        	//if (detonated[i]) continue;
        	result = Math.max(result, helper(bombs, i, new boolean[n]));
        }
        return result;
    }

	private int helper(int[][] bombs, int i, boolean[] detonated) {
		long radiusSquare = (1l * bombs[i][2]) * (1l * bombs[i][2]);
		int result = 1;
		detonated[i] = true;
		for (int j = 0; j < bombs.length; j++) {
			if (j == i || detonated[j]) continue;
			if (findDistance(bombs, i, j) <= radiusSquare) {
				result += helper(bombs, j, detonated);
			}
		}
		return result;
	}
	
	private long findDistance(int[][] bombs, int i , int j) {
		long xDis = Math.abs(bombs[i][0] - bombs[j][0]), yDis = Math.abs(bombs[i][1] - bombs[j][1]);
		return xDis * xDis + yDis * yDis;
	}
	
	public static void main(String[] args) {
		Problem2101 problem = new Problem2101();
		System.out.println(problem.maximumDetonation(new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}));
	}
}
