package com.prep2020.medium;
import java.util.*;
public class Problem325 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (map.containsKey(sum - k)) 
        		result = Math.max(result, i - map.get(sum - k));
        	if (!map.containsKey(sum)) map.put(sum, i);
        }
        return result;
    }
	
	
}
