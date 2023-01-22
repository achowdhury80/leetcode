package com.prep2020.medium;

public class Problem360 {
	/**
	 * O(N)
	 * @param nums
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
        int idx = a > 0 ? (n - 1) : 0, i = 0, j = nums.length - 1;
        int[] result = new int[nums.length];
        while(i <= j) {
        	int left = eval(a, b, c, nums[i]), right = eval(a, b, c, nums[j]);
        	if (a > 0) {
        		if (left > right) {
        			result[idx--] = left;
        			i++;
        		} else {
        			result[idx--] = right;
        			j--;
        		}
        	} else {
        		if (left < right) {
        			result[idx++] = left;
        			i++;
        		} else {
        			result[idx++] = right;
        			j--;
        		}
        	}
        }
        return result;
    }
	
	private int eval(int a, int b, int c, int x) {
		return a * x * x + b * x + c;
	}
}
