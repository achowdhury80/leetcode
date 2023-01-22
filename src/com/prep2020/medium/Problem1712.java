package com.prep2020.medium;

public class Problem1712 {
	public int waysToSplit(int[] nums) {
		int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) sum[i] = sum[i - 1] 
        		+ nums[i];
        int result = 0, mod = (int)(1e9 + 7);
        for (int i = 0; i < n - 2; i++) {
        	if (3l * sum[i] > sum[n - 1]) break;
        	int count = findCount(sum, i + 1);
        	result = (int)((0l + result + count) % mod);
        }
        return result;
    }

	private int findCount(int[] sum, int start) {
		int p1 = sum[start - 1];
		int p2EndMinIndex = -1;
		int low = start, high = sum.length - 2;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int val = sum[mid] - sum[start - 1];
			if (val >= sum[start - 1]) {
				p2EndMinIndex = mid;
				high = mid - 1;
			} else low = mid + 1;
		}
		if (p2EndMinIndex == -1) return 0;
		int p2EndHighIndex = -1;
		low = p2EndMinIndex;
		high = sum.length - 2;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int val2 = sum[mid] - sum[start - 1];
			int val3 = sum[sum.length - 1] - sum[mid];
			if (val3 >= val2) {
				p2EndHighIndex = mid;
				low = mid + 1;
			} else high = mid - 1;
		}
		if (p2EndHighIndex == -1) return 0;
		return p2EndHighIndex - p2EndMinIndex + 1;
	}
}
