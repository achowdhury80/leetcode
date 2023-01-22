package com.prep2020.easy;

public class Problem697 {
	/**
	 * O(1)
	 * @param nums
	 * @return
	 */
	public int findShortestSubArray(int[] nums) {
		// 0th freq, 1st start, length
        int[][] freq = new int[50000][3];
        for (int i = 0; i < nums.length; i++) {
        	freq[nums[i]][0]++;
        	if (freq[nums[i]][0] == 1) {
        		freq[nums[i]][1] = i;
        	}
        	freq[nums[i]][2] = i - freq[nums[i]][1] + 1;
        }
        int result = Integer.MAX_VALUE, maxFreq = 0;
        for (int i = 0; i < 50000; i++) {
        	if (freq[i][0] > maxFreq) {
        		maxFreq = freq[i][0];
        		result = freq[i][2];
        	} else if (freq[i][0] == maxFreq) {
        		result = Math.min(result, freq[i][2]);
        	}
        }
        return result;
    }
}
