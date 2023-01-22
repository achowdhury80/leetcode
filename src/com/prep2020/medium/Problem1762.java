package com.prep2020.medium;
public class Problem1762 {
	/**
	 * O(N) time and space
	 * @param heights
	 * @return
	 */
	public int[] findBuildings(int[] heights) {
		int n = heights.length;
        boolean[] canSee = new boolean[n];
        int max = heights[n - 1];
        canSee[n - 1] = true;
        int count = 1;
        for (int i = n - 1; i > -1; i--) {
        	if (heights[i] > max) {
        		canSee[i] = true;
        		count++;
        		max = heights[i];
        	}
        }
        int[] result = new int[count];
        int idx = 0;
        for (int i = 0; i < canSee.length; i++) {
        	if (canSee[i]) result[idx++] = i;
        }
        return result;
    }
}
