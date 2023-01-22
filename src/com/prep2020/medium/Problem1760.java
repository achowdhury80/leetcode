package com.prep2020.medium;

public class Problem1760 {
	/**
	 * O(nlog(maxBalls))
	 * @param nums
	 * @param maxOperations
	 * @return
	 */
	public int minimumSize(int[] nums, int maxOperations) {
        int high = Integer.MIN_VALUE;
        for (int num : nums) high = Math.max(high, num);
        int low = 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	int ops = findOps(nums, mid);
        	if (ops <= maxOperations) high = mid;
        	else low = mid + 1;
        }
        return high;
    }

	private int findOps(int[] nums, int mid) {
		int result = 0;
		for (int num : nums) result += (num - 1) / mid;
		return result;
	}
}
