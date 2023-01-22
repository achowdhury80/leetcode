package com.prep2020.medium;

public class Problem1131 {
	/**
	 * O(N)
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[][] maxNMin = new int[4][2];
        /**
         * 0th sum1- arr1[i] + arr2[i] + i 
         * 1st sum2- arr1[i] + arr2[i] - i
         * 2nd diff1- arr1[i] - arr2[i] + i
         * 3rd diff2- arr1[i] - arr2[i] - i
         * 
         * 0th max and 1st min
         */
        for (int i = 0; i < 4; i++) {
        	maxNMin[i][0] = Integer.MIN_VALUE;
        	maxNMin[i][1] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < arr1.length; i++) {
        	int sum1 = arr1[i] + arr2[i] + i;
        	int sum2 = arr1[i] + arr2[i] - i;
        	int diff1 = arr1[i] - arr2[i] + i;
        	int diff2 = arr1[i] - arr2[i] - i;
        	maxNMin[0][0] = Math.max(maxNMin[0][0], sum1);
        	maxNMin[0][1] = Math.min(maxNMin[0][1], sum1);
        	maxNMin[1][0] = Math.max(maxNMin[1][0], sum2);
        	maxNMin[1][1] = Math.min(maxNMin[1][1], sum2);
        	maxNMin[2][0] = Math.max(maxNMin[2][0], diff1);
        	maxNMin[2][1] = Math.min(maxNMin[2][1], diff1);
        	maxNMin[3][0] = Math.max(maxNMin[3][0], diff2);
        	maxNMin[3][1] = Math.min(maxNMin[3][1], diff2);
        }
        return Math.max(Math.max(maxNMin[0][0] - maxNMin[0][1], 
        		maxNMin[1][0] - maxNMin[1][1]), 
        		Math.max(maxNMin[2][0] - maxNMin[2][1], 
        				maxNMin[3][0] - maxNMin[3][1]));
    }
}
