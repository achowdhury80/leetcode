package com.prep2020.medium;

import java.util.Arrays;

public class Problem870 {
	/**
	 * O(nlogn) time and o(n) space
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> nums2[x] - nums2[y]);
        int[] result = new int[n];
        int endIdx = n - 1, arrIdx = 0;
        for (int i = 0; i < n; i++) {
        	int nums2Idx = arr[arrIdx];
        	if (nums1[i] > nums2[nums2Idx]) {
        		result[nums2Idx] = nums1[i];
        		arrIdx++;
        	} else result[arr[endIdx--]] = nums1[i];
        }
        return result;
    }
}
