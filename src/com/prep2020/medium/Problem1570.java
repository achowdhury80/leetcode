package com.prep2020.medium;

import java.util.*;

public class Problem1570 {
	private Map<Integer, Integer> map;
	Problem1570(int[] nums) {
		map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) 
        	if (nums[i] != 0) map.put(i, nums[i]);
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(Problem1570 vec) {
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	result += entry.getValue() * vec.map.getOrDefault(entry.getKey(), 0);
        }
        return result;
    }
}
