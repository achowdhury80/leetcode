package com.prep2020.easy;

public class Problem643 {
	/**
	 * O(N)
	 * @param nums
	 * @param k
	 * @return
	 */
	public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double result = -10001;
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	if (i >= k) sum -= nums[i - k];
        	if (i >= k - 1) {
        		result = Math.max(result, sum / k);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem643 problem = new Problem643();
		//System.out.println(problem.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
		System.out.println(problem.findMaxAverage(new int[] {-1}, 1));
	}
}
