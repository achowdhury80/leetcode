package comp.prep2019;
import java.util.*;
public class Prob22 {
	//O(2^n)
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n > 0) helper(n, 0, 0, result, "");
		return result;
    }
	
	private void helper(int n, int left, int right, List<String> result, String s) {
		if (n == left && n == right) {
			result.add(s);
			return;
		}
		if (left < n) helper(n, left + 1, right, result, s + "(");
		if (right < left) helper(n, left, right + 1, result, s + ")");
	}
}
