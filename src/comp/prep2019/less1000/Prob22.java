package comp.prep2019.less1000;
import java.util.*;
public class Prob22 {
	/*
	 * O(2^n)
	 * 
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n > 0) helper(n, 0, 0, result, "");
		return result;
    }
	
	private void helper(int n, int left, int right, List<String> result, String cur) {
		if (left == n) {
			for (int i = right + 1; i <= n; i++) cur += ")";
			result.add(cur);
			return;
		}
		helper(n, left + 1, right, result, cur + "(");
		if (right < left) helper(n, left, right + 1, result, cur + ")");
	}
}
