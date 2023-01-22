package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2091 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int minimumDeletions(int[] nums) {
		int n = nums.length;
		if (n == 1) return 1;
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < n; i++) {
        	if (nums[i] > nums[maxIndex]) maxIndex = i;
        	if (nums[i] < nums[minIndex]) minIndex = i;
        }
        int[] arr = new int[] {maxIndex, minIndex};
        Arrays.sort(arr);
        return Math.min(Math.min(Math.max(arr[0], arr[1]) + 1, 
        		n - Math.min(arr[0], arr[1])), arr[0] + 1 + n - arr[1]);
    }
}
