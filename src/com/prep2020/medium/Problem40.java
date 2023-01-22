package com.prep2020.medium;
import java.util.*;
public class Problem40 {
	/**
	 * O(2^n)
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, candidates, 0, new boolean[candidates.length], 0, target, 
        		new ArrayList<>());
        return result;
    }
	
	private void helper(List<List<Integer>> result, int[] candidates, int start, 
			boolean[] used, int curSum, int target, List<Integer> temp) {
		if (curSum == target) {
			result.add(new ArrayList<>(temp));
			return;
		}
		if (start == candidates.length) return;
		for (int i = start; i < candidates.length; i++) {
			if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) 
				continue;
			if (curSum + candidates[i] > target) break;
			used[i] = true;
			temp.add(candidates[i]);
			helper(result, candidates, i + 1, used, curSum + candidates[i], 
					target, temp);
			used[i] = false;
			temp.remove(temp.size() - 1);
		}
	}
}
