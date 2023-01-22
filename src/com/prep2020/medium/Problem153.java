package com.prep2020.medium;

public class Problem153 {
	/**
	 * O(logN)
	 * @param nums
	 * @return
	 */
	public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
        	int mid = low + (high - low) / 2;
        	if (nums[mid] > nums[high]) low = mid + 1;
        	else high = mid;
        }
        return nums[low];
    }
	
	public static void main(String[] args) {
		Problem153 problem = new Problem153();
		System.out.println(problem.findMin(new int[] {2, 3, 4, 5, 1}));
	}
}
