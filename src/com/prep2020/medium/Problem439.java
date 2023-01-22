package com.prep2020.medium;
import java.util.*;
public class Problem439 {
	/**
	 * O(N)
	 * @param expression
	 * @return
	 */
	public String parseTernary(String expression) {
		Deque<Character> stack = new ArrayDeque<>();
        for (int i = expression.length() - 1; i > -1; i--) {
        	char c = expression.charAt(i);
        	if (c == ':') continue;
        	if (!stack.isEmpty() && stack.peek() == '?') {
        		stack.pop();
        		char ch = stack.pop();
        		if (c == 'F') ch = stack.pop();
        		else stack.pop();
        		stack.push(ch);
        	} else stack.push(c);
        }
        return "" + stack.pop();
    }
}
