package com.prep2020.medium;

import java.util.Arrays;

public class Problem532 {
	/**
	 * O(nlogN)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	if (found(nums, i + 1, nums[i] + k)) result++;
        }
        return result;
    }

	private boolean found(int[] nums, int i, int num) {
		int low = i, high = nums.length - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == num) return true;
			if (nums[mid] > num) high = mid - 1;
			else low = mid + 1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Problem532 problem = new Problem532();
		System.out.println(problem.findPairs(new int[] {3, 1,4,1, 5}, 2));
	}
}
