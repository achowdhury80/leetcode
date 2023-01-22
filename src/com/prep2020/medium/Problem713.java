package com.prep2020.medium;

public class Problem713 {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0, prod = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	prod *= nums[i];
        	while(prod >= k && start <= i) {
        		prod /= nums[start++];
        	}
        	if (start <= i) result += (i - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem713 problem = new Problem713();
		//System.out.println(problem.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
		System.out.println(problem.numSubarrayProductLessThanK(new int[] {10,9,
				10,4,3,8,3,3,6,2,10,10,9,3},19));
	}
}
