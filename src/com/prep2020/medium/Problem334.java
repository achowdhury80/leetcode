package com.prep2020.medium;

public class Problem334 {
	/**
	 * o(n)
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length < 3) return false;
	    Integer[] two = new Integer[2];
	    two[0] = nums[0];  
	    for (int i = 1; i < nums.length; i++) {
	    	if (two[1] != null) {
	    		if (nums[i] > two[1]) return true;
	    		else if (nums[i] == two[1]) continue;
	    		if (two[0] > nums[i]) two[1] = nums[i];
	    		else two[0] = nums[i];
	    	} else {
	    		if (two[0] > nums[i]) two[0] = nums[i];
	    		else if(two[0] == nums[i]) continue;
	    		else two[1] = nums[i];
	    	}
	    }
	    return false;
    }
}
