package com.prep2020.hard;

import java.util.*;

public class Problem996 {
	/**
	 * O(n!)
	 * @param nums
	 * @return
	 */
	public int numSquarefulPerms(int[] nums) {
		if (nums.length < 2) return 0;
        Arrays.sort(nums);
        int[] result = new int[1];
        helper(nums, 0, new ArrayList<>(), result);
        return result[0];
    }
	
	private void helper(int[] nums, int used, List<Integer> cur, int[] result) {
		int n = nums.length;
		if (cur.size() == n) {
			result[0]++;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i > 0 && nums[i - 1] == nums[i] && (used & (1 << (i - 1))) == 0) continue;
			if ((used & (1 << i)) != 0) continue;
			if (!cur.isEmpty() && !isSquareFull(cur.get(cur.size() - 1), nums[i])) continue;
			cur.add(nums[i]);
			helper(nums, used | (1 << i), cur, result);
			cur.remove(cur.size() - 1);
		}
	}
	
	private boolean isSquareFull(int a, int b) {
		int sum =a + b;
		int sqrt = (int)Math.sqrt(sum);
		return sqrt * sqrt == sum;
	}
}
