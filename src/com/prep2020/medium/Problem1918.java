package com.prep2020.medium;
public class Problem1918 {
	/**
	 * O(nlogN) where N depends on the range of binary search
	 * @param nums
	 * @param k
	 * @return
	 */
	public int kthSmallestSubarraySum(int[] nums, int k) {
		int low = Integer.MAX_VALUE, high = 0;
		for (int num : nums) {
			low = Math.min(low, num);
			high += num;
		}
		int subSum = high;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (subPossible(nums, mid) >= k) {
				subSum = mid;
				high = mid - 1;
			} else low = mid + 1;
		}
		return subSum;
    }
	
	private int subPossible(int[] nums, int mid) {
		int start = 0, sum = 0, result = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while(sum > mid) sum -= nums[start++];
			result += i - start + 1;
		}
		return result;
	}

	
	
	public static void main(String[] args) {
		Problem1918 problem = new Problem1918();
		//System.out.println(problem.kthSmallestSubarraySum(new int[] {2, 1, 3}, 4));
		System.out.println(problem.kthSmallestSubarraySum(new int[] {3, 3, 5, 5}, 7));
	}
}
