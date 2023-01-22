package com.prep2020.medium;
import java.util.*;
public class Problem1726 {
	/**
	 * O(n^2) time and space
	 * @param nums
	 * @return
	 */
	public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		int prod = nums[i] * nums[j];
        		map.put(prod, map.getOrDefault(prod, 0) + 1);
        	}
        }
        int result = 0;
        for (int val : map.values()) {
        	if (val > 1) {
        		result += 4 * val * (val - 1);
        	}
        }
        return result;
    }
}
