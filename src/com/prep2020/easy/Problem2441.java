package com.prep2020.easy;

public class Problem2441 {
	public int findMaxK(int[] nums) {
        boolean[] pos = new boolean[1001], neg = new boolean[1001];
        int result = -1;
        for (int num : nums) {
        	if (num > 0) pos[num] = true;
        	else {
        		num = -num;
        		neg[num] = true;
        	}
        	if (pos[num] && neg[num]) result = Math.max(num, result);
        }
        return result;
    }
}
