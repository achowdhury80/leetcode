package com.prep2020.hard;
import java.util.*;
public class Problem1799 {
	public int maxScore(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n / 2, new HashMap<>());
    }
	
	private int helper(int[] nums, int mask, int level, Map<Integer, Integer> map) {
		int result = Integer.MIN_VALUE, n = nums.length;;
		if (mask == (1 << n) - 1) return 0;
		if (map.containsKey(mask)) return map.get(mask);
		for (int i = 0; i < n - 1; i++) {
			if ((mask & (1 << i)) > 0) continue;
			for (int j = i + 1; j < n; j++) {
				if ((mask & (1 << j)) > 0) continue;
				result = Math.max(result,  helper(nums, ((mask | (1 << i)) | (1 << j)), level - 1, map) + level * gcd(nums[i], nums[j]));
			}
			
		}
		map.put(mask, result);
		return result;
	}
	
	private int gcd(int x, int y) {
		if (y > x) return gcd(y, x);
		if (x % y == 0) return y;
		return gcd(y, x % y);
	}
}
