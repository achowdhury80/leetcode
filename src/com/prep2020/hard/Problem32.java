package com.prep2020.hard;

public class Problem32 {
	/**
	 * Two pass O(N) and O(1)
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
		if (s.length() < 1) return 0;
        return Math.max(traverse(s,  1, 0, ')'), traverse(s, -1, s.length() - 1, '('));
    }
	
	private int traverse(String s, int dir, int start, char c) {
		int result = 0, count = 0;
		int last = start;
		for (int i = 0; i < s.length(); i++) {
			int curIdx = start + dir * i;
			char ch = s.charAt(curIdx);
			if (ch != c) count++;
			else count--;
			if (count < 0) {
				count = 0;
				last = curIdx + dir; //next position
			}
			else if (count == 0) result = Math.max(result, Math.abs(curIdx - last ) + 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Problem32 problem = new Problem32();
		System.out.println(problem.longestValidParentheses(")()())"));
		System.out.println(problem.longestValidParentheses("()(()"));
	}
}
