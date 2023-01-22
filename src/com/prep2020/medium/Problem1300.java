package com.prep2020.medium;

public class Problem1300 {
	/**
	 * O(nlogN)
	 * @param arr
	 * @param target
	 * @return
	 */
	public int findBestValue(int[] arr, int target) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int i : arr) {
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        	sum += i;
        }
        if (sum <= target) return max;
        int low = 0, high = max - 1;
        int result = low, diff = Integer.MAX_VALUE;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	int curSum = findSum(arr, mid);
        	if (curSum == target) return mid;
        	if (curSum < target) low = mid + 1;
        	else high = mid - 1;
        	if (Math.abs(target - curSum) < diff) {
        		diff = Math.abs(target - curSum);
        		result = mid;
        	} else if (Math.abs(target - curSum) == diff && mid < result) {
        		result = mid;
        	}
        }
        return result;
    }

	private int findSum(int[] arr, int mid) {
		int result = 0;
		for (int i : arr) {
			if (i < mid) result += i;
			else result += mid;
		}
		return result;
	}
}
