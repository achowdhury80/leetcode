package com.leet.algo;

public class Prob674 {
	public int findLengthOfLCIS(int[] nums) {
	    if(nums == null || nums.length == 0) return 0;
	    if(nums.length == 1) return 1;
	    int result = 1;
	    int lastSubArrSize = 1;
	    for (int i = 1; i < nums.length; i++) {
	    	if (nums[i] > nums[i - 1]) {
	    		lastSubArrSize++;
	    		result = Math.max(result, lastSubArrSize);
	    	} else {
	    		lastSubArrSize = 1;
	    	}
	    }
	    return result;
	}
}
