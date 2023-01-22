package com.prep2020.medium;
import java.util.*;
public class Problem47 {
	/**
	 * O(n!)
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(), 0, result);
        return result;
    }
	
	private void helper(int[] nums, List<Integer> cur, int used, 
			List<List<Integer>> result) {
		if (cur.size() == nums.length) {
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (((used >> i) & 1) == 1 || (i > 0 && nums[i] == nums[i - 1] 
					&& (((used >> (i - 1)) & 1) == 0))) continue;
			cur.add(nums[i]);
			helper(nums, cur, used | (1 << i), result);
			cur.remove(cur.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Problem47 problem = new Problem47();
		System.out.println(problem.permuteUnique(new int[] {1, 1, 2}));
	}
}
