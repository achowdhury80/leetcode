package com.prep2020.medium;
import java.util.*;
public class Problem1190 {
	/**
	 * O(N) time and space
	 * @param s
	 * @return
	 */
	public String reverseParentheses(String s) {
		if (s == null || s.length() < 2) return s;
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = null;
        for (char c : s.toCharArray()) {
        	if (c != ')') stack.push(c);
        	else {
        		sb = new StringBuilder();
        		while((c = stack.pop()) != '(') {
        			sb.append(c);
        		}
        		for (int i = 0; i < sb.length(); i++) stack.push(sb.charAt(i));
        	}
        }
        sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
