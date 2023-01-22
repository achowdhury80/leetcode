package com.prep2020.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem856 {
	/**
	 * O(N)
	 * @param S
	 * @return
	 */
	public int scoreOfParentheses(String S) {
        Deque<String> stack = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
        	if (c == '(') stack.push("" + '(');
        	else {
        		int val = 0;
        		String st = stack.pop();
        		if ("(".equals(st)) val = 1;
        		else {
        			val = Integer.parseInt(st);
        			stack.pop();
        			val *= 2;
        			
        		}
        		
        		if (!stack.isEmpty() && !"(".equals(stack.peek())) {
    				val += Integer.parseInt(stack.pop());
    			}
        		stack.push("" + val);
        	}
        }
        return Integer.parseInt(stack.pop());
    }
	
	public static void main(String[] args) {
		Problem856 problem = new Problem856();
		System.out.println(problem.scoreOfParentheses("(())"));
	}
}
