package com.prep2020.medium;

public class Problem31 {
	/**
	 * O(N) time
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
        	if (nums[i] > nums[i - 1]) {
        		int j = i;
        		while(j < n) {
        			if (nums[j] <= nums[i - 1]) break;
        			j++;
        		}
        		j--;
        		swap(nums, i - 1, j);
        		reverse(nums, i, n - 1);
        		return;
        	}
        }
        reverse(nums, 0, n - 1);
    }
	
	private void reverse(int[] nums, int start, int end) {
		while(start < end) swap(nums, start++, end--);
	}
	
	private void swap(int[] nums, int i , int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		Problem31 problem = new Problem31();
		int[] arr = new int[] {1, 2, 3};
		problem.nextPermutation(arr);
		System.out.println(arr);
	}
}
