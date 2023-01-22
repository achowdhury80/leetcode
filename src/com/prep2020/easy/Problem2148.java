package com.prep2020.easy;

public class Problem2148 {
	/**
	 * O(n)
	 * @param nums
	 * @return
	 */
	public int countElements(int[] nums) {
        int[] min = new int[] {Integer.MAX_VALUE, 0}, 
        		max = new int[] {Integer.MIN_VALUE, 0};
        for (int num : nums) {
        	if (min[0] == num) min[1]++;
        	else if (min[0] > num) {
        		min = new int[] {num, 1};
        	}
        	if (max[0] == num) max[1]++;
        	else if (max[0] < num) {
        		max = new int[] {num, 1};
        	}
        }
        int result = nums.length - min[1] - max[1];
        return result < 0 ? 0 : result;
    }
}
