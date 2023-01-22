package com.prep2020.easy;

public class Problem1539 {
	public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	int missing = arr[mid] - (mid + 1);
        	if (missing >= k) right = mid - 1;
        	else left = mid + 1;
        }
        return left + k;
    }
}
