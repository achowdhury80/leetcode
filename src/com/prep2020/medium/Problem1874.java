package com.prep2020.medium;

public class Problem1874 {
	/**
	 * O(N) time
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int minProductSum(int[] nums1, int[] nums2) {
		int[] arr1 = new int[101], arr2 = new int[101];
		int n = nums1.length;
		for (int i = 0; i < n; i++) {
			arr1[nums1[i]]++;
			arr2[nums2[i]]++;
		}
		int result = 0, idx1 = 1, idx2 = 100;
		for (int i = 0; i < n; i++) {
			while(arr1[idx1] == 0) idx1++;
			while(arr2[idx2] == 0) idx2--;
			result += idx1 * idx2;
			arr1[idx1]--;
			arr2[idx2]--;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem1874 problem = new Problem1874();
		System.out.println(problem.minProductSum(new int[] {5, 3, 4, 2}, new int[] {4, 2, 2, 5}));
	}
}
