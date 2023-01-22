package com.prep2020.medium;
import java.util.*;
public class Problem1695 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maximumUniqueSubarray(int[] nums) {
		int n = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int result = Integer.MIN_VALUE, sum = 0, start = 0;
        for (int i = 0; i < n; i++) {
        	if (indexMap.containsKey(nums[i])) {
        		int lastIndex = indexMap.get(nums[i]);
        		for (int j = start; j <= lastIndex; j++) {
        			sum -= nums[j];
        			indexMap.remove(nums[j]);
        		}
        		start = lastIndex + 1;
        	}
        	indexMap.put(nums[i], i);
        	sum += nums[i];
        	result = Math.max(result, sum);
        }
        return result;
    }
}
