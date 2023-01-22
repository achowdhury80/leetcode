package com.prep2020.medium;

import java.util.Random;

public class Problem912 {
	/**
	 * quick sort
	 * O(NlogN)
	 * @param nums
	 * @return
	 */
	public int[] sortArray(int[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
        return nums;
    }
	
	private void sort(int[] arr, int start, int end) {
		if (start >= end) return;
		int pivot = partition(arr, start, end);
		sort(arr, start, pivot - 1);
		sort(arr, pivot + 1, end);
	}
	
	private int partition(int[] arr, int i, int j) {
		int lower = i;
		for (int k = i + 1; k <= j; k++) {
			if (arr[k] <= arr[i]) {
				lower++;
				swap(arr, lower, k);
			} 
		}
		swap(arr, i, lower);
		return lower;
	}
	
	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void shuffle(int[] arr) {
		Random random = new Random();
		for (int i = 1; i < arr.length; i++) {
			int j = random.nextInt(i);
			swap(arr, i, j);
		}
	}
}
