package com.prep2020.medium;
import java.util.*;
public class Problem128 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) set.add(num);
		int result = 0;
		for (int num : nums) {
			if (set.contains(num - 1)) continue;
			int curStreak = 1;
			while(set.contains(num + 1)) {
				curStreak++;
				num++;
			}
			result = Math.max(result, curStreak);
		}
		return result;
    }
}
