package com.prep2020.medium;

public class Problem573 {
	/**
	 * O(N)
	 * @param height
	 * @param width
	 * @param tree
	 * @param squirrel
	 * @param nuts
	 * @return
	 */
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result = 0, maxSave = Integer.MIN_VALUE;
        for (int i = 0; i < nuts.length; i++) {
        	int d = findDistance(tree, nuts[i]);
        	result += 2 * d;
        	int distance = findDistance(squirrel, nuts[i]);
        	if (d - distance > maxSave) maxSave = d - distance;
        }
        result -= maxSave;
        return result;
    }
	
	private int findDistance(int[] x, int[] y) {
		return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
	}
}
