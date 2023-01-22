package com.prep2020.hard;

public class Problem546 {
	public int removeBoxes(int[] boxes) {
        int[][][] dp = new int[101][101][101];
        return calculatePoints(boxes, dp, 0, boxes.length - 1, 0);
    }

	private int calculatePoints(int[] boxes, int[][][] dp, int l, int r, int k) {
		if (l > r) return 0;
		while(r > l && boxes[r - 1] == boxes[r]) {
			k++;
			r--;
		}
		if (dp[l][r][k] != 0) return dp[l][r][k];
		dp[l][r][k] = calculatePoints(boxes, dp, l, r - 1, 0) + (k + 1) * (k + 1);
		for (int i = l; i < r; i++) {
			if (boxes[i] == boxes[r]) dp[l][r][k] = Math.max(dp[l][r][k], calculatePoints(boxes, dp, l, i, k + 1) + calculatePoints(boxes, dp, i + 1, r - 1, 0));
		}
		return dp[l][r][k];
	}
}
