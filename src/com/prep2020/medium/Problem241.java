package com.prep2020.medium;
import java.util.*;
public class Problem241 {
	public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> result = new ArrayList<>();
		int nextOpIdx = findNextOperatorIndex(expression, 0);
		if (nextOpIdx == -1) {
			result.add(Integer.parseInt(expression));
			return result;
		}
		while(nextOpIdx > -1) {
			char c = expression.charAt(nextOpIdx);
			List<Integer> l1 = diffWaysToCompute(expression.substring(0, nextOpIdx));
			List<Integer> l2 = diffWaysToCompute(expression.substring(nextOpIdx + 1));
			for (int a : l1) {
				for (int b : l2) {
					if(c == '+') result.add(a + b);
					else if (c == '-') result.add(a - b);
					else result.add(a * b);
				}
			}
			nextOpIdx = findNextOperatorIndex(expression, nextOpIdx + 1);
		}
		return result;
    }
	
	private int findNextOperatorIndex(String input, int start) {
		for (int i = start; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') return i;
		}
		return -1;
	}
}
