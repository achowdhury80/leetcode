package com.prep2020.medium;
import java.util.*;
public class Problem1124 {
	/**
	 * O(N) time and space
	 * @param hours
	 * @return
	 */
	public int longestWPI(int[] hours) {
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
        	sum += hours[i] > 8 ? 1 : -1;
        	if (sum > 0) result = i + 1;
        	else {
        		map.putIfAbsent(sum, i);
        		if (map.containsKey(sum - 1)) result = Math.max(result, 
        				i - map.get(sum - 1));
        	}
        }
        return result;
    }
}
