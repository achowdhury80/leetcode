package com.prep2020.medium;
import java.util.*;
public class Problem39 {
	/**
	 * 
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), 0, target, result);
        return result;
    }
	
	private void helper(int[] candidates, int start, List<Integer> cur, 
			int sum, int target, List<List<Integer>> result) {
		if (sum == target) {
			result.add(cur);
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (sum + candidates[i] > target) break;
			List<Integer> list = new ArrayList<>(cur);
			list.add(candidates[i]);
			helper(candidates, i, list, sum + candidates[i], target, result);
		}
	}
}
