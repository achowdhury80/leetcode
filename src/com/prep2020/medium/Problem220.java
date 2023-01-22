package com.prep2020.medium;
import java.util.*;
public class Problem220 {
	/**
	 * O(nlogk)
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (i - k > 0) {
        		treeMap.put(nums[i - k - 1], treeMap.get(nums[i - k - 1]) - 1);
        		if (treeMap.get(nums[i - k - 1]) == 0) treeMap.remove(nums[i - k - 1]);
        	}
        	Integer floor = treeMap.floorKey(nums[i]);
        	if (floor != null && (long)nums[i] - floor <= t) return true;
        	Integer ceil = treeMap.ceilingKey(nums[i]);
        	if (ceil != null && (long)ceil - nums[i] <= t) return true;
        	treeMap.put(nums[i], treeMap.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
