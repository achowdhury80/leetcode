package comp.prep2019.less1000;
import java.util.*;
public class Prob216 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(k, n, 1, new ArrayList<>(), result);
		return result;
    }
	
	private void helper(int k, int n, int start, List<Integer> partial, List<List<Integer>> result) {
		if (k == 0 && n == 0) {
			result.add(new ArrayList<>(partial));
			return;
		}
		if (k == 0 || n <= 0) return;
		for (int i = start; i <= 9; i++) {
			partial.add(i);
			helper(k - 1, n - i, i + 1, partial, result);
			partial.remove(partial.size() - 1);
		}
	}
}
