package com.prep2020.medium;
import java.util.*;
public class Problem46 {
	/**
	 * O(2^n)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result);
        return result;
    }
	
	private void helper(int[] arr, int used, List<Integer> current, List<List<Integer>> result) {
		if (current.size() == arr.length) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (((used >> i) & 1) == 0) {
				current.add(arr[i]);
				helper(arr, used | (1 << i), current, result);
				current.remove(current.size() - 1);
			}
		}
	}
}
