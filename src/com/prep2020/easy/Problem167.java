package com.prep2020.easy;

public class Problem167 {
	/**
	 * O(N) time
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
        	int sum = numbers[i] + numbers[j];
        	if (sum == target) return new int[] {i + 1, j + 1};
        	if (sum > target) j--;
        	else i++;
        }
        return null;
    }
}
