package com.leet.algo;

public class Prob713 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;
        int prod = 1;
        int count = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] >= k) {
        		count = 0;
        		start = i + 1;
        		continue;
        	}
        	prod *= nums[i];
        	if (prod < k) {
        		count = i - start + 1;
        		result += count;
        	}
        	else {
        		while(prod >= k) {
        			prod /= nums[start++];
        		}
        		count = i - start + 1;
        		result += count;
        	}
        }
        return result;
    }
}
