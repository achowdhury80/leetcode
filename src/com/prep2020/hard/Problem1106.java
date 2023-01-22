package com.prep2020.hard;
import java.util.*;
public class Problem1106 {
	/**
	 * O(N) time and space
	 * @param expression
	 * @return
	 */
	public boolean parseBoolExpr(String expression) {
        if ("t".equals(expression)) return true;
        if ("f".equals(expression)) return false;
        char op = expression.charAt(0);
        if (op == '!') 
        	return !parseBoolExpr(expression.substring(2, expression.length() - 1));
        Iterator<String> itr = new ExpressionIterator(
        		expression.substring(2, expression.length() - 1));
        
        while(itr.hasNext()) {
        	String expr = itr.next();
        	boolean val = parseBoolExpr(expr);
        	if (op == '&' && !val) return false;
        	if (op == '|' && val) return true;
        }
        return op == '&';
    }
	class ExpressionIterator implements Iterator<String> {
		private String expression;
		private int index = 0;
		
		ExpressionIterator(String expression) {
			this.expression = expression;
		}
		
		@Override
		public boolean hasNext() {
			return index != expression.length();
		}

		@Override
		public String next() {
			int start = index;
			int count = 0;
			for (int i = start; i < expression.length(); i++) {
				char c = expression.charAt(i);
				if ('(' == c) count++;
				else if (')' == c) count--;
				else if (count == 0 && c == ',') {
					index = i + 1; 
					return expression.substring(start, i);
				}
			}
			index = expression.length();
			return expression.substring(start);
		}
	}
	public static void main(String[] args) {
		Problem1106 problem = new Problem1106();
		//System.out.println(problem.parseBoolExpr("|(f,t)"));
		System.out.println(problem.parseBoolExpr("|(&(t,f,t),!(t))"));
	}
}
