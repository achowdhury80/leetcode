package com.prep2020.easy;
import java.util.*;
public class Problem594 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @return
	 */
	public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (map.containsKey(entry.getKey() + 1)) 
        		result = Math.max(result, entry.getValue() + map.get(entry.getKey() + 1));
        }
        return result;
    }
}
