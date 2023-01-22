package com.prep2020.easy;

public class Problem2475 {
	public int unequalTriplets(int[] nums) {
       int n = nums.length, result = 0;
       for (int i = 0; i < n - 2; i++) {
    	   for (int j = i + 1; j < n - 1; j++) {
    		   if (nums[i] == nums[j]) continue;
    		   for (int k = j + 1; k < n; k++) {
    			   if (nums[i] == nums[k] || nums[j] == nums[k]) continue;
    			   result++;
    		   }
    	   }
       }
       return result;
    }
}
