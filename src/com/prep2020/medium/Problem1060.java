package com.prep2020.medium;

public class Problem1060 {
	/**
	 * O(logN)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int missingElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
        	int mid = low + (high - low) / 2;
        	if (low == mid) break;
        	int elementCount = mid - low + 1;
        	int missing = nums[mid] - nums[low] + 1 - elementCount;
        	if (k > missing) {
        		low = mid;
        		k -= missing;
        	} else if (k <= missing) high = mid;
        }
        int elementCount = high - low + 1;
    	int missing = nums[high] - nums[low] + 1 - elementCount;
        if (k <= missing) return nums[low] + k;
        return nums[high] + k - missing;
    }
	
	public static void main(String[] args) {
		Problem1060 problem = new Problem1060();
		System.out.println(problem.missingElement(new int[] {4, 7, 9, 10}, 1));
		System.out.println(problem.missingElement(new int[] {1, 2, 4}, 3));
	}
}
