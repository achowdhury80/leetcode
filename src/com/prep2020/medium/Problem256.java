package com.prep2020.medium;

public class Problem256 {
	/**
	 * O(N) time and O(1) space
	 * @param costs
	 * @return
	 */
	public int minCost(int[][] costs) {
		// 0th for red, 1st for blue and 2nd for green with last house color.
		// cumulative
		int[] last = new int[] {0, 0, 0};
		for (int i = 0; i < costs.length; i++) {
			int[] temp = new int[3];
			temp[0] = costs[i][0] + Math.min(last[1], last[2]);
			temp[1] = costs[i][1] + Math.min(last[2], last[0]);
			temp[2] = costs[i][2] + Math.min(last[0], last[1]);
			last = temp;
		}
		return Math.min(last[0], Math.min(last[1], last[2]));
    }
}
