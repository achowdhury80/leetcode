package com.prep2020.medium;

public class Problem1503 {
/**
 * O(N)
 * The left and right arrays do not gain a net new number of ants, only the ants 
 * themselves change directions. Therefore, in both cases, just moving the ants forward 
 * results in the correct net count of ants moving in each direction.
 */
	
	public int getLastMoment(int n, int[] left, int[] right) {
		int maxLeft = 0, minRight = n;
		for (int l : left) maxLeft = Math.max(maxLeft, l);
		for (int r : right) minRight = Math.min(minRight, r);
		return Math.max(maxLeft, n - minRight);
    }
}
