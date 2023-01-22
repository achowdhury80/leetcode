package com.prep2020.medium.more2000;

public class Problem2113 {
	public int[] elementInNums(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
        	int period = queries[i][0] / nums.length;
        	int rem = queries[i][0] % nums.length;
        	if (period % 2 == 0) {
        		if (queries[i][1] + rem >= nums.length) result[i] = -1;
        		else result[i] = nums[queries[i][1] + rem];
        	} else {
        		if (rem - 1 >= queries[i][1]) 
        			result[i] = nums[queries[i][1]];
        		else result[i] = -1;
        	}
        }
        return result;
    }
}
