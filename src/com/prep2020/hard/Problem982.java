package com.prep2020.hard;

import java.util.HashMap;
import java.util.Map;

public class Problem982 {
	/**
	 * O(N^2) time and space
	 * @param A
	 * @return
	 */
	public int countTriplets(int[] A) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : A) {
        	for (int b : A) {
        		countMap.put(a & b, countMap.getOrDefault(a & b, 0) + 1);
        	}
        }
        int result = 0;
        for (int a : A) {
        	for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        		if ((a & entry.getKey()) == 0) result += entry.getValue();
        	}
        }
        return result;
    }
}
