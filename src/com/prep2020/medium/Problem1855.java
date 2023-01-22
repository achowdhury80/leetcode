package com.prep2020.medium;

public class Problem1855 {
	/**
	 * O(mlogn)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int maxDistance(int[] nums1, int[] nums2) {
		int result = 0;
        for (int i = 0; i < nums1.length; i++) {
        	result = Math.max(result, findMaxDis(nums1[i], i + 1, nums2));
        }
        return result;
    }

	private int findMaxDis(int num, int j, int[] nums2) {
		if (j >= nums2.length) return 0;
		int low = j, high = nums2.length - 1;
		int maxIndex = Integer.MIN_VALUE; 
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if (nums2[mid] >= num) {
				maxIndex = mid;
				low = mid + 1;
			} else high = mid - 1;
		}
		return maxIndex == Integer.MIN_VALUE ? 0 : (maxIndex - j + 1);
	}
	
	public static void main(String[] args) {
		Problem1855 problem = new Problem1855();
		System.out.println(problem.maxDistance(new int[] {55,30,5,4,2},
				new int[] {100,20,10,10,5}));
	}
}
