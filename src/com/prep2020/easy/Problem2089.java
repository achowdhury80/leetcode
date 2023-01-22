package com.prep2020.easy;
import java.util.*;
public class Problem2089 {
	/**
	 * O(nlogn)
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
        	if (nums[i] == target) result.add(i);
        }
        return result;
    }
}
