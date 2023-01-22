package com.prep2020.medium;
import java.util.*;
public class Problem904 {
	/**
	 * O(N) time
	 * @param fruits
	 * @return
	 */
	public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0, start = 0;
        for (int i = 0; i < fruits.length; i++) {
        	map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
        	while(map.size() > 2) {
        		map.put(fruits[start], map.get(fruits[start]) - 1);
        		if (map.get(fruits[start]) == 0) map.remove(fruits[start]);
        		start++;
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
