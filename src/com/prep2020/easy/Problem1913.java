package com.prep2020.easy;

public class Problem1913 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxProductDifference(int[] nums) {
        int[] max = new int[] {-1, -1}, 
        		min = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int num : nums) {
        	if (num > max[1]) {
        		max[1] = num;
        		if (num > max[0]) {
        			max[1] = max[0];
        			max[0] = num;
        		}
        	}
        	if (num < min[0]) {
        		min[0] = num;
        		if (num < min[1]) {
        			min[0] = min[1];
        			min[1] = num;
        		}
        	}
        }
        return max[0] * max[1] - min[0] * min[1];
    }
}
