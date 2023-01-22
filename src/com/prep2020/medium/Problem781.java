package com.prep2020.medium;

import java.util.*;

public class Problem781 {
	/**
	 * O(N)
	 * @param answers
	 * @return
	 */
	public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : answers) map.put(i, map.getOrDefault(i, 0) + 1);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	int count = entry.getKey() + 1;
        	int val = entry.getValue();
        	do {
        		result += count;
        		val -= count;
        	} while (val > 0);
        }
        return result;
    }
}
