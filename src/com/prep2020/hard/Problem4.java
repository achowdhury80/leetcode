package com.prep2020.hard;

public class Problem4 {
	/**
	 * O(log(min(n1, n2)) or we can say O(log(n1 + n2))
	 * https://www.youtube.com/watch?v=LPFhl65R7ww
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length, n2 = nums2.length;
        int low = 0, high = n1;
        while(low <= high) {
        	int mid = low + (high - low) / 2;
        	int maxLeftX = mid == 0 ? Integer.MIN_VALUE : nums1[mid - 1], minRightX = mid == n1 ? Integer.MAX_VALUE : nums1[mid];
        	int partitionY = (n1 + n2 + 1) / 2 - mid;
        	int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY - 1], minRightY = partitionY == n2 ? Integer.MAX_VALUE 
        			: nums2[partitionY];
        	if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        		if ((n1 + n2) % 2 == 0) {
        			return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
        		} else return Math.max(maxLeftX, maxLeftY);
        	} else if (maxLeftX > minRightY) high = mid - 1;
        	else low = mid + 1;
        }
        throw new IllegalArgumentException();
    }
}
