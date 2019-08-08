package com.leet.algo;

public class Prob52 {
	public boolean canJump(int[] nums) {
        int maxSoFar = 0;
        for (int i = 0; i < nums.length - 1 && i <= maxSoFar && maxSoFar < nums.length - 1; i++) 
        	maxSoFar = Math.max(maxSoFar, i + nums[i]);
        return maxSoFar >= nums.length - 1;
    }
}
