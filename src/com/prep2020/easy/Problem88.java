package com.prep2020.easy;

public class Problem88 {
	/**
	 * O(m + n)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        while (m > 0 && n > 0) {
        	if (nums1[m - 1] < nums2[n - 1]) {
        		nums1[m + n - 1] = nums2[n - 1];
        		n--;
        	} else {
        		nums1[m + n - 1] = nums1[m - 1];
        		m--;
        	}
        }
        while (n > 0) {
        	nums1[n - 1] = nums2[n - 1];
        	n--;
        }
    }
}
