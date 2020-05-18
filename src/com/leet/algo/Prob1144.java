package com.leet.algo;

public class Prob1144 {
	public int movesToMakeZigzag(int[] nums) {
		int case1 = 0;
        for (int i = 0; i < nums.length; i += 2) {
        	int min = Math.min(i == 0 ? Integer.MAX_VALUE : nums[i - 1], 
        			i + 1 == nums.length ? Integer.MAX_VALUE : nums[i + 1]);
        	if (nums[i] >= min) case1 += (nums[i] - min + 1);
        }
        int case2 = 0;
        for (int i = 1; i < nums.length; i += 2) {
        	int min = Math.min(nums[i - 1], 
        			i + 1 == nums.length ? Integer.MAX_VALUE : nums[i + 1]);
        	if (nums[i] >= min) case2 += (nums[i] - min + 1);
        }
        return Math.min(case1, case2);
    }
}
