package com.prep2020.easy;

public class Problem1748 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for (int num : nums) arr[num]++;
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] == 1) sum += i;
        }
        return sum;
    }
}
