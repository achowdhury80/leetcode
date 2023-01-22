package com.prep2020.medium.more2000;

public class Problem2087 {
	public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
		int total_cost = 0;
		int x1 = Math.min(startPos[0], homePos[0]);
		int x2 = Math.max(startPos[0], homePos[0]);
		if (x1 < x2) {
			while (x1 != x2) {
				total_cost += startPos[0] < homePos[0] ? rowCosts[++x1] : rowCosts[x1++];
			}
		}
		int y1 = Math.min(startPos[1], homePos[1]);
		int y2 = Math.max(startPos[1], homePos[1]);
		if (y1 < y2) {
			while (y1 != y2) {
				total_cost += startPos[1] < homePos[1] ? colCosts[++y1] : colCosts[y1++];
			}
		}
		return total_cost;
	}
}
