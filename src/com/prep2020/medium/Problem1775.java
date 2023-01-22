package com.prep2020.medium;

import java.util.Arrays;

public class Problem1775 {
	public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int i : nums1) sum1 += i;
        for (int i : nums2) sum2 += i;
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) return helper(nums2, nums1, sum1 - sum2);
        return helper(nums1, nums2, sum2 - sum1);
    }
	
	private int helper(int[] toIncrease, int[] toDecrease, int diff) {
		Arrays.sort(toIncrease);
		Arrays.sort(toDecrease);
		int i = 0, j = toDecrease.length - 1, result = 0;
		while(i < toIncrease.length || j > -1) {
			if (j < 0 || i < toIncrease.length && 6 - toIncrease[i] >= toDecrease[j] - 1) {
				diff -= 6 - toIncrease[i];
				result++;
				i++;
				if (diff <= 0) return result;
			} else {
				diff -= toDecrease[j] - 1;
				result++;
				j--;
				if (diff <= 0) return result;
			}
		}
		return -1;
	}
}
