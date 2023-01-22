package com.prep2020.medium;

import java.util.Arrays;

public class Problem1885 {
	/**
	 * https://leetcode.com/problems/count-pairs-in-two-arrays/discuss/1467647/Python-3-or-Math-Binary-Search-or-Explanation
	 */
	public long countPairs(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) diff[i] = nums1[i] - nums2[i];
        Arrays.sort(diff);
        long result = 0;
        for (int i = 0; i < diff.length - 1; i++) {
        	int minIndex = findMinIndex(diff, -diff[i], i + 1);
        	if (minIndex > -1) result += (0l + diff.length - minIndex);
        }
        return result;
    }

	private int findMinIndex(int[] diff, int min, int start) {
		int end = diff.length - 1;
		while(start < end) {
			int mid = (int)(start + (end - start) / 2);
			if (diff[mid] > min) end = mid;
			else start = mid + 1;
		}
		if (start > end || start == end && diff[start] <= min) return -1;
		return start;
	}
	
	public static void main(String[] args) {
		Problem1885 problem = new Problem1885();
		System.out.println(problem.countPairs(new int[] {2,1,2,1}, new int[] {1, 2, 1, 2}));
	}

}
