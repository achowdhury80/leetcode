package com.prep2020.medium;
import java.util.*;
public class Problem442 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if (nums.length < 2) return result;
		for (int num : nums) {
			int idx = Math.abs(num) - 1;
			if (nums[idx] < 0) result.add( Math.abs(num));
			else nums[idx] *= -1;
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem442 problem = new Problem442();
		System.out.println(problem.findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
	}
}
