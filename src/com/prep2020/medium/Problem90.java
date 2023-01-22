package com.prep2020.medium;
import java.util.*;
public class Problem90 {
	/**
	 * O(2^n)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, 0, new ArrayList<>(), result);
        return result;
    }
	
	private void helper(int[] nums, int start, int used, List<Integer> cur,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(cur));
		for (int i = start; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1] && ((used >> (i - 1)) & 1) == 0) continue;
			cur.add(nums[i]);
			helper(nums, i + 1, used | (1 << i), cur, result);
			cur.remove(cur.size() - 1);
		}
	}
}
