package com.prep2020.hard;

public class Problem41 {
	/**
	 * O(N) time and O(1) space with input modified.
	 * 1st check if 1 is missing, if yes return 1
	 * check all the elements 1 if it is less than 1 or more than n
	 * now loop through each element. For each element present, set nums[element] negative
	 * if element == n, set nums[0] negative
	 * now loop through each element starting from 2. if positive found, then the missing number is that index
	 * if num[0] is positive then result is n
	 * otherwise result is n + 1
	 * @param nums
	 * @return
	 */
	public int firstMissingPositive(int[] nums) {
		boolean missingOne = true;
		int n = nums.length;
        for (int num : nums) {
        	if (num == 1) {
        		missingOne = false;
        		break;
        	}
        }
        if (missingOne) return 1;
        for (int i = 0; i < n; i++) {
        	if (nums[i] < 1 || nums[i] > n) nums[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
        	int num = Math.abs(nums[i]);
        	if (num == n) nums[0] = -Math.abs(nums[0]);
        	else nums[num] = - Math.abs(nums[num]);
        }
        for (int i = 2; i < n; i++) {
        	if (nums[i] > 0) return i;
        }
        if (nums[0] > 0) return n;
        return n + 1;
    }
	
	public static void main(String[] args) {
		Problem41 problem = new Problem41();
		System.out.println(problem.firstMissingPositive(new int[] {1, 2, 0}));
	}
}
