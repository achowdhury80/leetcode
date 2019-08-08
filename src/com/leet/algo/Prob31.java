package com.leet.algo;

public class Prob31 {
	public void nextPermutation(int[] nums) {
	    if(nums.length == 0 || nums == null) return;
	    for (int i = nums.length - 2; i > -1; i--) {
	    	if (nums[i] < nums[i + 1]) {
	    		for (int j = nums.length - 1; j > i; j--) {
	    			if (nums[j] > nums[i]) {
	    				int temp = nums[j];
	    				nums[j] = nums[i];
	    				nums[i] = temp;
	    				reverse(nums, i + 1);
	    				return;
	    			}
	    		}
	    	}
	    }
	    reverse(nums, 0);
	  }

	  private void reverse(int[] nums, int startIndex){
	    for(int i = startIndex, j = nums.length - 1; j > i; i++, j--){
	      int temp = nums[i];
	      nums[i] = nums[j];
	      nums[j] = temp;
	    }
	  }
}
