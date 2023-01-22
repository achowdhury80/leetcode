package com.prep2020.medium;
import java.util.*;
public class Problem150 {
	/**
	 * O(N)
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
        	if (isOp(token)) {
        		int last = stack.pop();
        		stack.push(evaluate(stack.pop(), token, last));
        	} else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
	
	private boolean isOp(String token) {
		return "+-*/".indexOf(token) > -1;
	}
	
	private int evaluate(int oprnd1, String op, int oprnd2) {
		switch(op) {
		case "+" : return oprnd1 + oprnd2;
		case "-" : return oprnd1 - oprnd2;
		case "*" : return oprnd1 * oprnd2;
		case "/" : return oprnd1 / oprnd2;
		default: return 0;
		}
	}
}
