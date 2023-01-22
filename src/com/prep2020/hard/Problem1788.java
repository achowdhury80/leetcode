package com.prep2020.hard;

import java.util.*;

public class Problem1788 {
	/**
	 * O(N) time and space
	 * @param flowers
	 * @return
	 */
	public int maximumBeauty(int[] flowers) {
		int[] arr = new int[flowers.length];
		Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < flowers.length; i++) {
        	if (i != 0) arr[i] = arr[i - 1];
        	arr[i] += Math.max(0, flowers[i]);
        	int[] indices = map.getOrDefault(flowers[i], new int[] {-1, -1});
        	if (indices[0] == -1) indices[0] = i;
        	else indices[1] = i;
        	map.put(flowers[i], indices);
        }
        int result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
        	if (entry.getValue()[1] == -1) continue;
        	int beauty = 2 * entry.getKey();
        	int start = entry.getValue()[0] + 1;
        	int end = entry.getValue()[1] - 1;
        	if (start <= end) beauty += (arr[end] - arr[start - 1]);
        	result = Math.max(result, beauty);
        }
        return result;
    }
}
