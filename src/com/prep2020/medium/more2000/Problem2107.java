package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2107 {
	/**
	 * O(n) time and space
	 * @param candies
	 * @param k
	 * @return
	 */
	public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : candies) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int i = 0; i < k; i++) {
        	map.put(candies[i], map.get(candies[i]) - 1);
        	if (map.get(candies[i]) == 0) map.remove(candies[i]);
        }
        int result = map.size();
        for (int i = k; i < candies.length; i++) {
        	map.put(candies[i], map.get(candies[i]) - 1);
        	if (map.get(candies[i]) == 0) map.remove(candies[i]);
        	map.put(candies[i - k], map.getOrDefault(candies[i - k], 0) + 1);
        	result = Math.max(result, map.size());
        }
        return result;
    }
}
