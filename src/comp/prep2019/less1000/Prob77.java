package comp.prep2019.less1000;
import java.util.*;
public class Prob77 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		helper(n, new ArrayList<>(), 1, k, result);
		return result;
    }
	
	private void helper(int n, List<Integer> list, int start, int k, 
			List<List<Integer>> result) {
		if (list.size() == k) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = start; i <= n; i++) {
			list.add(i);
			helper(n, list, i + 1, k, result);
			list.remove(list.size() - 1);
		}
	}
}
