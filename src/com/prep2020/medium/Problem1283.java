package com.prep2020.medium;

public class Problem1283 {
	/**
	 * O(log(range))
	 * @param nums
	 * @param threshold
	 * @return
	 */
	public int smallestDivisor(int[] nums, int threshold) {
		int low = 1, high = Integer.MIN_VALUE;
		for (int num : nums) high = Math.max(high, num);
        int result = Integer.MAX_VALUE;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	if(findDivSum(nums, mid) <= threshold) {
        		result = mid;
        		high = mid - 1;
        	} else low = mid + 1;
        }
        return result;
    }

	private int findDivSum(int[] nums, int mid) {
		int result = 0;
		for (int num : nums) result += (int)Math.ceil((num + 0.) / mid);
		return result;
	}
}
