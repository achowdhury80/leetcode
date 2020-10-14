package comp.prep2019;
import java.util.*;
public class Prob39 {
	/**
	 * O(2^n) time and space
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		helper(candidates, 0, result, target, new ArrayList<>());
        return result;
    }
	
	private void helper(int[] candidates, int start, List<List<Integer>> result, int target, List<Integer> list) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target < candidates[i]) break;
			list.add(candidates[i]);
			helper(candidates, i, result, target - candidates[i], list);
			list.remove(list.size() - 1);
		}
	}
}
