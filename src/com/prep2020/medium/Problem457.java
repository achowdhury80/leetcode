package com.prep2020.medium;
import java.util.*;
public class Problem457 {
	/*
	 * O(n)
	 * for each index set the value to -1001-index to signify it is visited (-1000 is valid value)
	 * if it reaches the same value after moving toward a single direction we have a cycle
	 * if it gets other number less than -1000, that path was traversed before 
	 */
	public boolean circularArrayLoop(int[] nums) {
        if (nums.length < 2) return false;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] < -1000) continue;
        	boolean positive = nums[i] > 0;
        	if (isCycle(nums, i, positive)) return true;
        }
        return false;
    }
	
	private boolean isCycle(int[] nums, int index, boolean positive) {
		int i = index, nextI;
		int visitedVal = -1001 - index;
		while(true) {
			nextI = ((i + nums[i]) % nums.length + nums.length) % nums.length;
			if (i == nextI) return false;
			if(nums[nextI] == visitedVal) return true;
			if (nums[nextI] > 0 != positive || nums[nextI] < -1000) return false;
			nums[i] = visitedVal;
			i = nextI;
		}
	}
}
