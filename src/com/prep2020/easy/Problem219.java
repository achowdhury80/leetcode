package com.prep2020.easy;
import java.util.*;
public class Problem219 {
	/**
	 * O(N) and o(K) space
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (i > k) {
        		map.put(nums[i - k - 1], map.get(nums[i - k - 1]) - 1);
        		if (map.get(nums[i - k - 1]) == 0) map.remove(nums[i - k - 1]);
        	}
        	if (map.containsKey(nums[i])) return true;
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
