package com.prep2020.easy;
import java.util.*;
public class Problem1207 {
	/**
	 * O(N) time and space
	 * @param arr
	 * @return
	 */
	public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
	
}
