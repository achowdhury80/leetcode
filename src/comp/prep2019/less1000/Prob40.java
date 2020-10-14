package comp.prep2019.less1000;
import java.util.*;
public class Prob40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (candidates.length < 1) return result;
		Arrays.sort(candidates);
		helper(candidates, target, 0, new ArrayList<>(), result);
		return result;
    }
	
	private void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i - 1] == candidates[i]) continue;
			if (target - candidates[i] < 0) break;
			list.add(candidates[i]);
			helper(candidates, target - candidates[i], i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}
}
