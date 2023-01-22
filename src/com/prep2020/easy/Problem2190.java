package com.prep2020.easy;
import java.util.*;
public class Problem2190 {
	public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i - 1] == key) freq.put(nums[i], 
        			freq.getOrDefault(nums[i], 0) + 1);
        }
        int[] result = new int[] {-1, -1};
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        	if (entry.getValue() > result[1]) {
        		result[0] = entry.getKey();
        		result[1] = entry.getValue();
        	}
        }
        return result[0];
    }
}
