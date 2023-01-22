package com.prep2020.easy;

public class Problem2529 {
	public int maximumCount(int[] nums) {
        int n = nums.length;
        if (nums[n - 1] < 0) return n;
        if (nums[0] > 0) return n;
        int i = 0, j = n - 1;
        while(i < j) {
        	int mid = i + (j - i) / 2;
        	if (nums[mid] == 0) {
        		int neg = 0, pos = 0;
        		for (int x = mid - 1; x > -1; x--) {
        			if (nums[x] != 0) {
        				neg = x + 1;
        				break;
        			}
        		}
        		for (int x = mid + 1; x < n; x++) {
        			if (nums[x] != 0) {
        				pos = n - x;
        				break;
        			}
        		}
        		return Math.max(pos, neg);
        	}
        	if (nums[mid] > 0) j = mid - 1;
        	else i = mid + 1;
        }
        if (i > j) {
        	
        } else {
        	if (nums[i] > 0) return Math.max(i, n - i);
        	else return Math.max(i + 1, n - i - 1);
        }
    }
	
	private int findIndex(int[] nums, int target) {
		int n = nums.length;
		int i = 0, j = n - 1;
		while(i < j) {
			int mid = i + (j - i) / 2;
			if (nums[i] > -1) {
				j = i - 1;
			} else i 
		}
	}
}
