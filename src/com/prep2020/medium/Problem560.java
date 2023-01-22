package com.prep2020.medium;
import java.util.*;
public class Problem560 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, result = 0;
        for (int i : nums) {
        	sum += i;
        	result += map.getOrDefault(sum - k, 0);
        	map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
