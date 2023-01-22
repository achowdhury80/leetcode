package com.prep2020.medium;

import java.util.TreeMap;

public class Problem1296 {
	/**
	 *  O(NlogN)
	 * @param hand
	 * @param groupSize
	 * @return
	 */
	public boolean isPossibleDivide(int[] nums, int k) {
		int n = nums.length, min = Integer.MAX_VALUE;
        if (n % k != 0) return false;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int h : nums) {
        	min = Math.min(min, h);
        	treeMap.put(h, treeMap.getOrDefault(h, 0) + 1);
        }
        
        while(!treeMap.isEmpty()) {
        	int cur = treeMap.ceilingKey(min);
        	min = cur;
        	treeMap.put(cur, treeMap.get(cur) - 1);
        	if (treeMap.get(cur) == 0) treeMap.remove(cur);
        	for (int i = 1; i < k; i++) {
        		cur++;
        		if (treeMap.containsKey(cur)) {
        			treeMap.put(cur, treeMap.get(cur) - 1);
        			if (treeMap.get(cur) == 0) treeMap.remove(cur);
        		} else return false;
        	}
        }
        return true;
    }
}
