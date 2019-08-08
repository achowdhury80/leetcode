package com.leet.algo;
import java.util.*;
public class Prob912 {
	public int[] sortArray(int[] nums) {
        shuffle(nums);
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }
	
	private void sortArray(int[] nums, int start, int end) {
        int part = partition(nums, start, end);
        if (part - start > 1) sortArray(nums, start, part - 1);
        if (end - part > 1) sortArray(nums, part + 1, end);
    }
	
	private int partition(int[] arr, int start, int end) {
		if (start == end) return start;
		int pivot = start, lower = start;
		int i = start;
		while(i < end) {
			i++;
			if (arr[i] <= arr[pivot]) {
				exchange(arr, ++lower, i);
			}
		}
		exchange(arr, pivot, lower);
		return lower;
	}
	
	private void shuffle(int[] arr) {
		Random random = new Random();
		for (int i = 1; i < arr.length; i++) {
			int r = random.nextInt(i);
			exchange(arr, i, r);
		}
		
	}
	
	private void exchange(int[] arr, int i, int j) {
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	
	
}
