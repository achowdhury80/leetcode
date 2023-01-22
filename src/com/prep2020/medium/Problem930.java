package com.prep2020.medium;
import java.util.*;
public class Problem930 {
	/**
	 * O(N)
	 * @param nums
	 * @param goal
	 * @return
	 */
	public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	result += map.getOrDefault(sum - goal, 0);
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
