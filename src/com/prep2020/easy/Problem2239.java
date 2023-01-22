package com.prep2020.easy;

public class Problem2239 {
	public int findClosestNumber(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i : nums) {
        	if (Math.abs(i) < Math.abs(result) || (Math.abs(i) == Math.abs(result) && i > result)) result = i;
        }
        return result;
    }
}
