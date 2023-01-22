package com.prep2020.medium;
import java.util.*;
public class Problem22 {
	/*
	 * O(2^n)
	 * 
	 */
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		helper(n, "", 0, 0, result);
		return result;
    }
	
	private void helper(int n, String cur, int leftCount, int rightCount, List<String> result) {
		if (rightCount < leftCount) {
			helper(n, cur + ")", leftCount, rightCount + 1, result);
		} 
		
		if (leftCount < n) helper(n, cur + "(", leftCount + 1, rightCount, result);
		
		if (leftCount == n && rightCount == n) result.add(cur);
	}
}
