package com.prep2020.medium.more2000;

public class Problem2090 {
	public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = -1;
        for (int i = 0; i < n; i++) {
        	sum += nums[i];
        	if (i - 2 * k > 0) sum -= nums[i - 2 * k - 1];
        	if (i >= 2 * k) result[i - k] = (int)(sum / (2 * k + 1));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2090 problem = new Problem2090();
		System.out.println(problem.getAverages(new int[] {7,4,3,9,1,8,5,2,6}, 3));
	}
}
