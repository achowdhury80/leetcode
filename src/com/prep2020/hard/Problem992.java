package com.prep2020.hard;
import java.util.*;
public class Problem992 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraysWithKDistinct(int[] nums, int k) {
		return findAtMost(nums, k) - findAtMost(nums, k - 1);
    }
	
	/**
	 * find the number of sub-arrays having atleast k different integers
	 * @param nums
	 * @param k
	 * @return
	 */
	private int findAtMost(int[] nums, int k) {
		int n = nums.length;
		if (k <= 0) return 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		int left = 0, right = 0;
		int result = 0;
		while(right < n) {
			countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
			while(left < right && countMap.size() > k) {
				countMap.put(nums[left], countMap.get(nums[left]) - 1);
				if (countMap.get(nums[left]) == 0) countMap.remove(nums[left]);
				left++;
			}
			result += right - left + 1;
			right++;
		}
		return result;
	}
}
