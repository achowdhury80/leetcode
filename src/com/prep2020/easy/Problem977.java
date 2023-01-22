package com.prep2020.easy;

public class Problem977 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0, j = nums.length - 1, idx = nums.length - 1;
        while (i < j) {
        	int left = nums[i] * nums[i], right = nums[j] * nums[j];
        	if ( left >= right) {
        		result[idx--] = left;
        		i++;
        	} else {
        		result[idx--] = right;
        		j--;
        	}
        }
        result[idx] = nums[i] * nums[i];
        return result;
    }
	
	public static void main(String[] args) {
		Problem977 problem = new Problem977();
		int[] result = problem.sortedSquares(new int[] {-7,-3,2,3,11});
		System.out.println(result);
	}
}
