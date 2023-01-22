package com.prep2020.medium;
import java.util.*;
public class Problem1438 {
	/**
	 * o(NlogN)
	 * @param nums
	 * @param limit
	 * @return
	 */
	public int longestSubarray(int[] nums, int limit) {
        int result = 1, start = 0;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
        	int index = -1;
        	while(list.size() > 0 && (Math.abs(nums[i] - list.get(0)) > limit
        			|| Math.abs(nums[i] - list.get(list.size() - 1)) > limit)) {
        		index = Collections.binarySearch(list, nums[start++]);
        		list.remove(index);
        	}
        	index = Collections.binarySearch(list, nums[i]);
        	if (index < 0) index = -(index + 1);
        	list.add(index, nums[i]);
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
