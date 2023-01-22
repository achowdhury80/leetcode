package com.prep2020.medium;
import java.util.*;
public class Problem1658 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @param x
	 * @return
	 */
	public int minOperations(int[] nums, int x) {
        int target = 0;
        for (int i : nums) target += i;
        target -= x;
        if (target == 0) return nums.length;
        int maxSize = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (map.containsKey(sum - target)) maxSize = 
        			Math.max(maxSize, i - map.get(sum - target));
        	map.put(sum, i);
        }
        if (maxSize == 0) return -1;
        return nums.length - maxSize;
    }
}
