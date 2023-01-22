package com.prep2020.easy;

public class Problem1979 {
	public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
        	min = Math.min(min, num);
        	max = Math.max(max, num);
        }
        return findHcf(max, min);
    }
	
	private int findHcf(int a, int b) {
		if (b == 0) return a;
		return findHcf(b, a % b);
	}
}
