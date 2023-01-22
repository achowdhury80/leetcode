package com.prep2020.medium;

public class Problem1151 {
	/**
	 * O(N)
	 * @param data
	 * @return
	 */
	public int minSwaps(int[] data) {
        int noOfones = 0;
        for (int i : data) {
        	if(i == 1) noOfones++;
        }
        int count = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
        	if (data[i] == 1) count++;
        	if (i >= noOfones - 1) {
        		if (i >= noOfones && data[i - noOfones] == 1) count--;
        		result = Math.min(result, noOfones - count);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1151 problem = new Problem1151();
		System.out.println(problem.minSwaps(new int[] {1, 0, 1, 0, 1}));
	}
}
