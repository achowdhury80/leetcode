package com.prep2020.medium;
import java.util.*;
public class Problem1218 {
	/**
	 * O(N) time and space
	 * @param arr
	 * @param difference
	 * @return
	 */
	public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i : arr) {
        	int count = map.getOrDefault(i - difference, 0);
        	map.put(i, count + 1);
        	result = Math.max(result, count + 1);
        }
        return result;
    }
}
