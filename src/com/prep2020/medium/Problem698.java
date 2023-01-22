package com.prep2020.medium;

import java.util.Arrays;

public class Problem698 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % k != 0)
			return false;
		int target = sum / k;
		Arrays.sort(nums);
	    return isPossible(nums, target, new int[k], nums.length - 1);
	}

	private boolean isPossible(int[] nums, int sum, int[] subsetSum, int lastIndex) {
		if (lastIndex == -1) {
			for (int s : subsetSum)
				if (s != sum)
					return false;
			return true;
		}
		int num = nums[lastIndex];
		for (int i = 0; i < subsetSum.length; i++) {
			if (sum - subsetSum[i] >= num) {
				subsetSum[i] += num;
				if (isPossible(nums, sum, subsetSum, lastIndex - 1))
					return true;
				subsetSum[i] = subsetSum[i] - num;
			}
		}
		return false;
	}
}
