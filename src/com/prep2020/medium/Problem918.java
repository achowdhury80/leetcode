package com.prep2020.medium;

public class Problem918 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0, minSum = Integer.MAX_VALUE, 
        		maxSum = Integer.MIN_VALUE, curPosSum = 0, curNegSum = 0;
        for (int num : nums) {
        	totalSum += num;
        	curPosSum += num;
        	maxSum = Math.max(maxSum, curPosSum);
        	if (curPosSum < 0) curPosSum = 0;
        	curNegSum += num;
        	minSum = Math.min(minSum, curNegSum);
        	if (curNegSum > 0) curNegSum = 0;
        }
        return Math.max(maxSum, totalSum == minSum ? Integer.MIN_VALUE 
        		: (totalSum - minSum));
    }
	
	public static void main(String[] args) {
		Problem918 problem = new Problem918();
		System.out.println(problem.maxSubarraySumCircular(new int[] {
				-3, -2, -3}));
	}
}
